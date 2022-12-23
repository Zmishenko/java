package task5;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import java.util.Objects;

public class Form extends JFrame implements ActionListener {

    private JPanel panel1;
    private JTextField textBox;
    private JButton makeDir;
    private JButton setDir;
    private JButton showFiles;
    private JButton chooseFile;
    private JButton removeFile;
    private JButton renameFile;
    private JButton cancel;
    private JList jList;
    DefaultListModel<String> list = new DefaultListModel<>();
    private JPanel panel2;
    private JPanel panel3;
    private JButton readFile;
    private JButton copyFile;
    private File file = new File("C:\\Users\\user\\Desktop\\JavaProjects\\Новая папка");
    private File selectedFile = null;

    @Serial
    private static final long serialVersionUID = 1L;

    Form(){
        cancel.addActionListener(this);
        makeDir.addActionListener(this);
        setDir.addActionListener(this);
        showFiles.addActionListener(this);
        chooseFile.addActionListener(this);
        removeFile.addActionListener(this);
        renameFile.addActionListener(this);
        readFile.addActionListener(this);
        copyFile.addActionListener(this);

        jList.setLayoutOrientation(JList.VERTICAL);
        jList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (jList.getSelectedValue() != null){
                    textBox.setText(jList.getSelectedValue().toString());
                }
            }
        });
        jList.setVisible(true);

        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(468, 358));
        setSize(468, 358); // устанавливаем желательные размеры
        setLocation((getCenter(getWidth(), getHeight())));
        setVisible(true); // отображаем окно
    }

    private Point getCenter(int sizeWidth, int sizeHeight){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int locationX = (screenSize.width - sizeWidth) / 2;
        int locationY = (screenSize.height - sizeHeight) / 2;
        Point point = new Point();
        point.setLocation(locationX, locationY);
        return point;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("cancel")){
            dispose();
        }
        if (e.getActionCommand().equals("makeDir")){
            System.out.println("makeDir");

            if (textBox.getText().equals("")){
                //chooseFiles(JFileChooser.DIRECTORIES_ONLY);
                file = new File("C:\\Users\\user\\Desktop\\JavaProjects\\new Folder\\");
            }else {
                file = new File(textBox.getText());
            }

            if(!file.exists()){
                JOptionPane.showMessageDialog(new JFrame("Ошибка!"), "Такой директории не существует!");
                System.out.println("Такой директории не существует");
            }else {
                JOptionPane.showMessageDialog(new JFrame("Успешно!"), "Директория успешно добавлена!");
                System.out.println("Директория успешно добавлена");
                textBox.setText(file.getPath());
                addFiles(file);
            }
        }
        if (e.getActionCommand().equals("setDir")){
            System.out.println("setDir");
            file = new File(textBox.getText());
            boolean created = file.mkdir();
            if(created){
                JOptionPane.showMessageDialog(new JFrame("Успешно!"), "Folder has been created!");
                textBox.setText(file.getPath());
                System.out.println("Folder has been created");
            }else {
                JOptionPane.showMessageDialog(new JFrame("Ошибка!"), "Такая папка уже есть!");
            }
        }
        if (e.getActionCommand().equals("showFiles")){
            System.out.println("showFiles");
            addFiles(file);
            showFiles();
            //chooseFiles(JFileChooser.FILES_AND_DIRECTORIES);
        }
        if (e.getActionCommand().equals("chooseFile")) {
            System.out.println("chooseFile");
            selectedFile = chooseFiles(JFileChooser.FILES_ONLY);
            if (selectedFile == null){
                JOptionPane.showMessageDialog(new JFrame("Ошибка!"), "Вы не выбрали файл!");
            }else {
                JOptionPane.showMessageDialog(new JFrame("Успешно!"), selectedFile.getName());
                textBox.setText(selectedFile.getName());
            }

        }
        if (e.getActionCommand().equals("removeFile")){
            System.out.println("removeFile");

            if (getSelectedFile().delete()){
                JOptionPane.showMessageDialog(new JFrame("Успешно!"), "Файл удален!");
            }
        }
        if (e.getActionCommand().equals("renameFile")) {
            System.out.println("renameFile");

            File selectedFile = getSelectedFile();
            String name = selectedFile.getName().split("\\.")[0];
            System.out.println(name);
            String path = selectedFile.getPath().replaceFirst(name,  textBox.getText());
            System.out.println(path);
            File newDir = new File(path);
            textBox.setText(selectedFile.getName() + " renameTo " + newDir.getName());
            selectedFile.renameTo(newDir);
        }
        if (e.getActionCommand().equals("readFile")) {
            System.out.println("readFile");
            System.out.println(jList.getSelectedValue());
            Desktop desktop = Desktop.getDesktop();
            if(getSelectedFile().exists()) {
                try {
                    desktop.open(getSelectedFile()); 
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }

        }
        if (e.getActionCommand().equals("copyFile")){
            System.out.println("copyFile");
            try {
                copyFiles(getSelectedFile(), new File(file.getPath() + "\\" + textBox.getText()));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    private void copyFiles(File first, File second) throws IOException {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try{
            inputStream = new FileInputStream(first);
            outputStream = new FileOutputStream(second);

            byte[] bytes = new byte[1024];
            int length;
            while ((length = inputStream.read(bytes)) > 0){
                outputStream.write(bytes, 0, length);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            inputStream.close();
            outputStream.close();
        }
    }

    private void addFiles(File file){
        list.clear();
        for(File item : Objects.requireNonNull(file.listFiles())){

            if(item.isDirectory()){
                list.addElement(item.getName());
            }
            else{
                list.addElement(item.getName());
            }
        }
    }

    private void showFiles(){
        if (!list.isEmpty()){
            jList.setListData(list.toArray());
            jList.validate();
        }
    }

    private File chooseFiles(int selectionMode){
        File selectedFile = null;
        JFileChooser jFileChooser = new JFileChooser(file.getPath());
        jFileChooser.setVisible(true);
        jFileChooser.setDialogTitle("Выбор директории");
        // Определение режима - только каталог
        jFileChooser.setFileSelectionMode(selectionMode);
        int result = jFileChooser.showOpenDialog(new JFrame());
        // Если директория выбрана, покажем ее в сообщении
        if (result == JFileChooser.APPROVE_OPTION){
            selectedFile = jFileChooser.getSelectedFile();
            addFiles(file);
        }
        
        return selectedFile;
    }

    private File getSelectedFile(){
        File selectedFile = null;
        for(File item : Objects.requireNonNull(file.listFiles())){
            if(item.getName().equals(jList.getSelectedValue().toString())){
                selectedFile = item;
                break;
            }
        }

        return selectedFile;
    }
}
