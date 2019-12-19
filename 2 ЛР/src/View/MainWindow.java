package View;

import Controller.Controller;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainWindow extends JFrame
{
    private final int WIDTH=1200;
    private final int HEIGHT=600;
    private Container mainContainer;
    private SpringLayout layout;
    private Controller controller;

    public MainWindow(Controller controller)
    {
        this.controller=controller;

        setTitle("Учёт приказов и распоряжений");
        setSize(new Dimension(WIDTH, HEIGHT));
        setLocation(new Point(300,100));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        mainContainer =this.getContentPane();
        layout=new SpringLayout();

        JMenuBar menuBar=new JMenuBar();
        JMenu menu=new JMenu("Меню");
        JMenuItem add=new JMenuItem("Добавить");
        JMenuItem edit=new JMenuItem("Редактировать");
        JMenuItem delete=new JMenuItem("Удалить");
        JMenuItem search=new JMenuItem("Поиск");
        JMenuItem exit=new JMenuItem("Выход");
        menu.add(add);
        menu.add(edit);
        menu.add(delete);
        menu.add(search);
        menu.addSeparator();
        menu.add(exit);
        menuBar.add(menu);
        setJMenuBar(menuBar);
        addNewData();

        add.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                mainContainer.removeAll();
                addNewData();
            }
        });
        edit.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                mainContainer.removeAll();
                editData();
            }
        });
        delete.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                mainContainer.removeAll();
                deleteData();
            }
        });
        search.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                mainContainer.removeAll();
                searchData();
            }
        });
        exit.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    private void addNewData()
    {
        JTabbedPane tabbedPane=new JTabbedPane();

        Container addNewOrderContainer=new Container();
        Container addNewCorrespondentContainer=new Container();
        Container addNewOrderEventContainer=new Container();

        addNewOrderContainer.setLayout(layout);
        addNewCorrespondentContainer.setLayout(layout);
        addNewOrderEventContainer.setLayout(layout);

        JLabel numberLabel=new JLabel("Номер:");
        JLabel number2Label=new JLabel("Номер:");
        JLabel dateLabel=new JLabel("Дата:");
        JLabel contentLabel=new JLabel("Содержание:");
        JLabel headLabel=new JLabel("Руководитель:");
        JLabel eventLabel=new JLabel("Мероприятие:");
        JLabel responsibleManLabel=new JLabel("Ответсвенный:");
        JLabel dateEventLabel=new JLabel("Дата:");
        JLabel markLabel=new JLabel("Выполнено:");
        JLabel fioLabel=new JLabel("ФИО:");
        JLabel positionLabel=new JLabel("Должность:");
        JLabel divisionLabel=new JLabel("Подразделение:");

        JTextField numberTextField=new JTextField(20);
        JTextField number2TextField=new JTextField(20);
        JTextField dateTextField=new JTextField(20);
        JTextField dateEventTextField=new JTextField(20);
        JComboBox markComboBox=new JComboBox(new String[]{"Да", "Нет"});
        JTextField fioTextField=new JTextField(20);
        JTextField positionTextField=new JTextField(20);
        JTextField divisionTextField=new JTextField(20);

        JTextArea headTextArea=new JTextArea("ФИО\nподразделение\nдолжность",3, 20);
        headTextArea.setLineWrap(true);
        headTextArea.setWrapStyleWord(true);
        JScrollPane headScrollPane=new JScrollPane(headTextArea);
        JTextArea contentTextArea=new JTextArea(10, 20);
        contentTextArea.setLineWrap(true);
        contentTextArea.setWrapStyleWord(true);
        JScrollPane contentScrollPane=new JScrollPane(contentTextArea);
        JTextArea eventTextArea=new JTextArea(5,20);
        eventTextArea.setLineWrap(true);
        eventTextArea.setWrapStyleWord(true);
        JScrollPane eventScrollPane=new JScrollPane(eventTextArea);
        JTextArea responsibleManTextArea=new JTextArea(3, 20);
        responsibleManTextArea.setLineWrap(true);
        responsibleManTextArea.setWrapStyleWord(true);
        JScrollPane responsibleManScrollPane=new JScrollPane(responsibleManTextArea);

        JButton addNewOrderButton=new JButton("Добавить");
        JButton addNewCorrespondentButton=new JButton("Добавить");
        JButton addNewOrderEventButton=new JButton("Добавить");

        addNewOrderContainer.add(numberLabel);
        addNewOrderContainer.add(numberTextField);
        addNewOrderContainer.add(dateLabel);
        addNewOrderContainer.add(dateTextField);
        addNewOrderContainer.add(contentLabel);
        addNewOrderContainer.add(contentScrollPane);
        addNewOrderContainer.add(headLabel);
        addNewOrderContainer.add(headScrollPane);
        addNewOrderContainer.add(eventLabel);
        addNewOrderContainer.add(eventScrollPane);
        addNewOrderContainer.add(responsibleManLabel);
        addNewOrderContainer.add(responsibleManScrollPane);
        addNewOrderContainer.add(dateEventLabel);
        addNewOrderContainer.add(dateEventTextField);
        addNewOrderContainer.add(markLabel);
        addNewOrderContainer.add(markComboBox);
        addNewOrderContainer.add(addNewOrderButton);

        addNewOrderEventContainer.add(number2Label);
        addNewOrderEventContainer.add(number2TextField);
        addNewOrderEventContainer.add(eventLabel);
        addNewOrderEventContainer.add(eventScrollPane);
        addNewOrderEventContainer.add(responsibleManLabel);
        addNewOrderEventContainer.add(responsibleManScrollPane);
        addNewOrderEventContainer.add(dateEventLabel);
        addNewOrderEventContainer.add(dateEventTextField);
        addNewOrderEventContainer.add(markLabel);
        addNewOrderEventContainer.add(markComboBox);
        addNewOrderEventContainer.add(addNewOrderEventButton);


        addNewCorrespondentContainer.add(fioLabel);
        addNewCorrespondentContainer.add(fioTextField);
        addNewCorrespondentContainer.add(positionLabel);
        addNewCorrespondentContainer.add(positionTextField);
        addNewCorrespondentContainer.add(divisionLabel);
        addNewCorrespondentContainer.add(divisionTextField);
        addNewCorrespondentContainer.add(addNewCorrespondentButton);

        final int width1=120;
        final int width2=20;

        layout.putConstraint(SpringLayout.NORTH, numberLabel, 5, SpringLayout.NORTH, addNewOrderContainer);
        layout.putConstraint(SpringLayout.WEST, numberLabel, width2, SpringLayout.WEST, addNewOrderContainer);
        layout.putConstraint(SpringLayout.NORTH, numberTextField, 5, SpringLayout.NORTH, addNewOrderContainer);
        layout.putConstraint(SpringLayout.WEST, numberTextField, width1, SpringLayout.WEST, addNewOrderContainer);
        layout.putConstraint(SpringLayout.NORTH, dateLabel, 5, SpringLayout.SOUTH, numberTextField);
        layout.putConstraint(SpringLayout.WEST, dateLabel, width2, SpringLayout.WEST, addNewOrderContainer);
        layout.putConstraint(SpringLayout.NORTH, dateTextField, 5, SpringLayout.SOUTH, numberTextField);
        layout.putConstraint(SpringLayout.WEST, dateTextField, 0, SpringLayout.WEST, numberTextField);
        layout.putConstraint(SpringLayout.NORTH, contentLabel, 5, SpringLayout.SOUTH, dateTextField);
        layout.putConstraint(SpringLayout.WEST, contentLabel, width2, SpringLayout.WEST, addNewOrderContainer);
        layout.putConstraint(SpringLayout.NORTH, contentScrollPane, 5, SpringLayout.SOUTH, dateTextField);
        layout.putConstraint(SpringLayout.WEST, contentScrollPane, 0, SpringLayout.WEST, dateTextField);
        layout.putConstraint(SpringLayout.NORTH, headLabel, 5, SpringLayout.SOUTH, contentScrollPane);
        layout.putConstraint(SpringLayout.WEST, headLabel, width2, SpringLayout.WEST, addNewOrderContainer);
        layout.putConstraint(SpringLayout.NORTH, headScrollPane, 5, SpringLayout.SOUTH, contentScrollPane);
        layout.putConstraint(SpringLayout.WEST, headScrollPane, 0, SpringLayout.WEST, contentScrollPane);
        layout.putConstraint(SpringLayout.NORTH, addNewOrderButton, 5, SpringLayout.SOUTH, headScrollPane);
        layout.putConstraint(SpringLayout.WEST, addNewOrderButton, width1+50, SpringLayout.WEST, addNewOrderContainer);

        layout.putConstraint(SpringLayout.NORTH, number2Label, 5, SpringLayout.NORTH, addNewOrderEventContainer);
        layout.putConstraint(SpringLayout.WEST, number2Label, width2, SpringLayout.WEST, addNewOrderEventContainer);
        layout.putConstraint(SpringLayout.NORTH, number2TextField, 5, SpringLayout.NORTH, addNewOrderEventContainer);
        layout.putConstraint(SpringLayout.WEST, number2TextField, width1, SpringLayout.WEST, addNewOrderEventContainer);
        layout.putConstraint(SpringLayout.NORTH, eventLabel, 20, SpringLayout.SOUTH, number2TextField);
        layout.putConstraint(SpringLayout.WEST, eventLabel, width2, SpringLayout.WEST, addNewOrderEventContainer);
        layout.putConstraint(SpringLayout.NORTH, eventScrollPane, 5, SpringLayout.SOUTH, number2TextField);
        layout.putConstraint(SpringLayout.WEST, eventScrollPane, 0, SpringLayout.WEST,number2TextField);
        layout.putConstraint(SpringLayout.NORTH, responsibleManLabel, 5, SpringLayout.SOUTH, eventScrollPane);
        layout.putConstraint(SpringLayout.WEST, responsibleManLabel, width2, SpringLayout.WEST, addNewCorrespondentContainer);
        layout.putConstraint(SpringLayout.NORTH, responsibleManScrollPane, 5, SpringLayout.SOUTH, eventScrollPane);
        layout.putConstraint(SpringLayout.WEST, responsibleManScrollPane, 0, SpringLayout.WEST, eventScrollPane);
        layout.putConstraint(SpringLayout.NORTH, dateEventLabel, 5, SpringLayout.SOUTH, responsibleManScrollPane);
        layout.putConstraint(SpringLayout.WEST, dateEventLabel, width2, SpringLayout.WEST, addNewOrderContainer);
        layout.putConstraint(SpringLayout.NORTH, dateEventTextField, 5, SpringLayout.SOUTH, responsibleManScrollPane);
        layout.putConstraint(SpringLayout.WEST, dateEventTextField, 0, SpringLayout.WEST, responsibleManScrollPane);
        layout.putConstraint(SpringLayout.NORTH, markLabel, 5, SpringLayout.SOUTH, dateEventTextField);
        layout.putConstraint(SpringLayout.WEST, markLabel, width2, SpringLayout.WEST, addNewCorrespondentContainer);
        layout.putConstraint(SpringLayout.NORTH, markComboBox, 5, SpringLayout.SOUTH, dateEventTextField);
        layout.putConstraint(SpringLayout.WEST, markComboBox, 0, SpringLayout.WEST, dateEventTextField);
        layout.putConstraint(SpringLayout.NORTH, addNewOrderEventButton, 5, SpringLayout.SOUTH, markComboBox);
        layout.putConstraint(SpringLayout.WEST, addNewOrderEventButton, width1+50, SpringLayout.WEST, addNewOrderContainer);



        layout.putConstraint(SpringLayout.NORTH, fioLabel, 20, SpringLayout.NORTH, addNewCorrespondentContainer);
        layout.putConstraint(SpringLayout.WEST, fioLabel, width2-18, SpringLayout.WEST, addNewCorrespondentContainer);
        layout.putConstraint(SpringLayout.NORTH, fioTextField,20, SpringLayout.NORTH, addNewCorrespondentContainer);
        layout.putConstraint(SpringLayout.WEST, fioTextField, width1, SpringLayout.WEST, addNewCorrespondentContainer);
        layout.putConstraint(SpringLayout.NORTH, positionLabel, 5, SpringLayout.SOUTH, fioTextField);
        layout.putConstraint(SpringLayout.WEST, positionLabel, 0, SpringLayout.WEST, fioLabel);
        layout.putConstraint(SpringLayout.NORTH, positionTextField, 5, SpringLayout.SOUTH, fioTextField);
        layout.putConstraint(SpringLayout.WEST, positionTextField, 0, SpringLayout.WEST, fioTextField);
        layout.putConstraint(SpringLayout.NORTH, divisionLabel, 5, SpringLayout.SOUTH, positionTextField);
        layout.putConstraint(SpringLayout.WEST, divisionLabel, 0, SpringLayout.WEST, positionLabel);
        layout.putConstraint(SpringLayout.NORTH, divisionTextField, 5, SpringLayout.SOUTH, positionTextField);
        layout.putConstraint(SpringLayout.WEST, divisionTextField, 0, SpringLayout.WEST, positionTextField);
        layout.putConstraint(SpringLayout.NORTH, addNewCorrespondentButton, 10, SpringLayout.SOUTH, divisionTextField);
        layout.putConstraint(SpringLayout.WEST, addNewCorrespondentButton, 50, SpringLayout.WEST, divisionTextField);

        JPanel grid = new JPanel();
        GridLayout layout = new GridLayout(1, 3, 5, 12);
        grid.setLayout(layout);
        grid.add(addNewOrderContainer);
        grid.add(addNewOrderEventContainer);
        grid.add(addNewCorrespondentContainer);
        getContentPane().add(grid);
        setVisible(true);



        addNewOrderButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                boolean answer=true;
                String number=numberTextField.getText();
                String date=dateTextField.getText();
                String content=contentTextArea.getText();
                String head=headTextArea.getText();
                if(number.equals(""))
                {
                    numberTextField.setBackground(Color.YELLOW);
                    answer=false;
                }
                if(date.equals(""))
                {
                    dateTextField.setBackground(Color.YELLOW);
                    answer=false;
                }
                if(head.equals("ФИО\nподразделение\nдолжность"))
                {
                    headTextArea.setBackground(Color.YELLOW);
                    answer=false;
                }
                if(answer!=false)
                {
                    answer=controller.addNewOrder(number, date, content, head);
                    if(answer==false)
                        showErrorMessage();
                    numberTextField.setText("");
                    numberTextField.setBackground(Color.WHITE);
                    dateTextField.setText("");
                    dateTextField.setBackground(Color.WHITE);
                    contentTextArea.setText("");
                    headTextArea.setText("ФИО\nподразделение\nдолжность");
                    headTextArea.setBackground(Color.WHITE);
                }
            }
        });

        addNewOrderEventButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                boolean answer=true;
                String number=number2TextField.getText();
                String event=eventTextArea.getText();
                String responsibleMan=responsibleManTextArea.getText();
                String dateEvent=dateEventTextField.getText();
                String mark=(String) markComboBox.getSelectedItem();
                if(number.equals(""))
                {
                    number2TextField.setBackground(Color.YELLOW);
                    answer=false;
                }
                if(event.equals(""))
                {
                    eventTextArea.setBackground(Color.YELLOW);
                    answer=false;
                }
                if(responsibleMan.equals(""))
                {
                    responsibleManTextArea.setBackground(Color.YELLOW);
                    answer=false;
                }
                if(dateEvent.equals(""))
                {
                    dateEventTextField.setBackground(Color.YELLOW);
                    answer=false;
                }
                if(mark.equals(""))
                {
                    markComboBox.setBackground(Color.YELLOW);
                    answer=false;
                }
                if(answer!=false)
                {
                    answer=controller.addNewOrderEvent(number, event, responsibleMan, dateEvent, mark);
                    if(answer==false)
                        showErrorMessage();
                    number2TextField.setText("");
                    number2TextField.setBackground(Color.WHITE);
                    eventTextArea.setText("");
                    eventTextArea.setBackground(Color.WHITE);
                    responsibleManTextArea.setText("");
                    responsibleManTextArea.setBackground(Color.WHITE);
                    dateEventTextField.setText("");
                    dateEventTextField.setBackground(Color.WHITE);
                    markComboBox.setBackground(Color.WHITE);
                }
            }
        });

        addNewCorrespondentButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                boolean answer=true;
                String fio=fioTextField.getText();
                String position=positionTextField.getText();
                String division_name=divisionTextField.getText();
                if(fio.equals(""))
                {
                    fioTextField.setBackground(Color.YELLOW);
                    answer=false;
                }
                if(position.equals(""))
                {
                    positionTextField.setBackground(Color.YELLOW);
                    answer=false;
                }
                if(division_name.equals(""))
                {
                    divisionTextField.setBackground(Color.YELLOW);
                    answer=false;
                }
                if(answer!=false)
                {
                    answer = controller.addNewCorrespondent(fio, division_name, position);
                    if(answer==false)
                        showErrorMessage();
                    fioTextField.setText("");
                    fioTextField.setBackground(Color.WHITE);
                    positionTextField.setText("");
                    positionTextField.setBackground(Color.WHITE);
                    divisionTextField.setText("");
                    divisionTextField.setBackground(Color.WHITE);
                }
            }
        });

        mainContainer.add(tabbedPane);

        revalidate();
        repaint();
    }

    private void editData()
    {
        JTabbedPane tabbedPane=new JTabbedPane();

        Container editOrderContainer=new Container();
        Container editCorrespondentContainer=new Container();

        editOrderContainer.setLayout(layout);
        editCorrespondentContainer.setLayout(layout);

        JLabel numberLabel=new JLabel("Номер:");
        numberLabel.setForeground(Color.GRAY);
        JLabel dateLabel=new JLabel("Дата:");
        dateLabel.setForeground(Color.GRAY);
        JLabel contentLabel=new JLabel("Содержание:");
        contentLabel.setForeground(Color.GRAY);
        JLabel headLabel=new JLabel("Руководитель:");
        headLabel.setForeground(Color.GRAY);
        JLabel eventLabel=new JLabel("Мероприятие:");
        eventLabel.setForeground(Color.GRAY);
        JLabel responsibleManLabel=new JLabel("Ответсвенный:");
        responsibleManLabel.setForeground(Color.GRAY);
        JLabel dateEventLabel=new JLabel("Дата:");
        dateEventLabel.setForeground(Color.GRAY);
        JLabel markLabel=new JLabel("Выполнено:");
        markLabel.setForeground(Color.GRAY);
        JLabel fioLabel=new JLabel("ФИО:");
        fioLabel.setForeground(Color.GRAY);
        JLabel positionLabel=new JLabel("Должность:");
        positionLabel.setForeground(Color.GRAY);
        JLabel divisionLabel=new JLabel("Подразделение:");
        divisionLabel.setForeground(Color.GRAY);

        JTextField numberTextField=new JTextField(20);
        numberTextField.setEnabled(false);
        JTextField dateTextField=new JTextField(20);
        dateTextField.setEnabled(false);
        JTextField dateEventTextField=new JTextField(20);
        dateEventTextField.setEnabled(false);
        JTextField fioTextField=new JTextField(20);
        fioTextField.setEnabled(false);
        JTextField positionTextField=new JTextField(20);
        positionTextField.setEnabled(false);
        JTextField divisionTextField=new JTextField(20);
        divisionTextField.setEnabled(false);

        JTextArea headTextArea=new JTextArea("ФИО\nподразделение\nдолжность",3, 20);
        headTextArea.setEnabled(false);
        headTextArea.setLineWrap(true);
        headTextArea.setWrapStyleWord(true);
        JScrollPane headScrollPane=new JScrollPane(headTextArea);
        JTextArea contentTextArea=new JTextArea(10, 20);
        contentTextArea.setEnabled(false);
        contentTextArea.setLineWrap(true);
        contentTextArea.setWrapStyleWord(true);
        JScrollPane contentScrollPane=new JScrollPane(contentTextArea);
        JTextArea eventTextArea=new JTextArea(5,20);
        eventTextArea.setEnabled(false);
        eventTextArea.setLineWrap(true);
        eventTextArea.setWrapStyleWord(true);
        JScrollPane eventScrollPane=new JScrollPane(eventTextArea);
        JTextArea responsibleManTextArea=new JTextArea(3, 20);
        responsibleManTextArea.setEnabled(false);
        responsibleManTextArea.setLineWrap(true);
        responsibleManTextArea.setWrapStyleWord(true);
        JScrollPane responsibleManScrollPane=new JScrollPane(responsibleManTextArea);

        DefaultComboBoxModel correspondentComboBoxModel=new DefaultComboBoxModel(controller.getListCorrespondents());
        JComboBox correspondentComboBox=new JComboBox(correspondentComboBoxModel);
        JComboBox markComboBox=new JComboBox(new String[]{"Да", "Нет"});
        markComboBox.setEnabled(false);
        JComboBox orderComboBox=new JComboBox(controller.getListOrders());
        JComboBox eventComboBox=new JComboBox();
        eventComboBox.setEnabled(false);

        JButton editOrderButton=new JButton("Изменить");
        editOrderButton.setEnabled(false);
        JButton editCorrespondentButton=new JButton("Изменить");
        editCorrespondentButton.setEnabled(false);

        editOrderContainer.add(orderComboBox);
        editOrderContainer.add(numberLabel);
        editOrderContainer.add(numberTextField);
        editOrderContainer.add(dateLabel);
        editOrderContainer.add(dateTextField);
        editOrderContainer.add(contentLabel);
        editOrderContainer.add(contentScrollPane);
        editOrderContainer.add(headLabel);
        editOrderContainer.add(headScrollPane);
        editOrderContainer.add(eventComboBox);
        editOrderContainer.add(eventLabel);
        editOrderContainer.add(eventScrollPane);
        editOrderContainer.add(responsibleManLabel);
        editOrderContainer.add(responsibleManScrollPane);
        editOrderContainer.add(dateEventLabel);
        editOrderContainer.add(dateEventTextField);
        editOrderContainer.add(markLabel);
        editOrderContainer.add(markComboBox);
        editOrderContainer.add(editOrderButton);

        editCorrespondentContainer.add(correspondentComboBox);
        editCorrespondentContainer.add(fioLabel);
        editCorrespondentContainer.add(fioTextField);
        editCorrespondentContainer.add(positionLabel);
        editCorrespondentContainer.add(positionTextField);
        editCorrespondentContainer.add(divisionLabel);
        editCorrespondentContainer.add(divisionTextField);
        editCorrespondentContainer.add(editCorrespondentButton);

        final int width1=200;
        final int width2=100;

        layout.putConstraint(SpringLayout.NORTH, orderComboBox, 5, SpringLayout.NORTH, editOrderContainer);
        layout.putConstraint(SpringLayout.WEST, orderComboBox, 5, SpringLayout.WEST, editOrderContainer);
        layout.putConstraint(SpringLayout.SOUTH, orderComboBox, 0, SpringLayout.SOUTH, numberTextField);
        layout.putConstraint(SpringLayout.EAST, orderComboBox, 50, SpringLayout.WEST, numberLabel);
        layout.putConstraint(SpringLayout.NORTH, numberLabel, 5, SpringLayout.NORTH, editOrderContainer);
        layout.putConstraint(SpringLayout.WEST, numberLabel, width2, SpringLayout.WEST, editOrderContainer);
        layout.putConstraint(SpringLayout.NORTH, numberTextField, 5, SpringLayout.NORTH, editOrderContainer);
        layout.putConstraint(SpringLayout.WEST, numberTextField, width1, SpringLayout.WEST, editOrderContainer);
        layout.putConstraint(SpringLayout.NORTH, dateLabel, 5, SpringLayout.SOUTH, numberTextField);
        layout.putConstraint(SpringLayout.WEST, dateLabel, width2, SpringLayout.WEST, editOrderContainer);
        layout.putConstraint(SpringLayout.NORTH, dateTextField, 5, SpringLayout.SOUTH, numberTextField);
        layout.putConstraint(SpringLayout.WEST, dateTextField, 0, SpringLayout.WEST, numberTextField);
        layout.putConstraint(SpringLayout.NORTH, contentLabel, 5, SpringLayout.SOUTH, dateTextField);
        layout.putConstraint(SpringLayout.WEST, contentLabel, width2, SpringLayout.WEST, editOrderContainer);
        layout.putConstraint(SpringLayout.NORTH, contentScrollPane, 5, SpringLayout.SOUTH, dateTextField);
        layout.putConstraint(SpringLayout.WEST, contentScrollPane, 0, SpringLayout.WEST, dateTextField);
        layout.putConstraint(SpringLayout.NORTH, headLabel, 5, SpringLayout.SOUTH, contentScrollPane);
        layout.putConstraint(SpringLayout.WEST, headLabel, width2, SpringLayout.WEST, editOrderContainer);
        layout.putConstraint(SpringLayout.NORTH, headScrollPane, 5, SpringLayout.SOUTH, contentScrollPane);
        layout.putConstraint(SpringLayout.WEST, headScrollPane, 0, SpringLayout.WEST, contentScrollPane);
        layout.putConstraint(SpringLayout.NORTH, eventComboBox, 0, SpringLayout.NORTH, eventScrollPane);
        layout.putConstraint(SpringLayout.WEST, eventComboBox, 5, SpringLayout.WEST, editOrderContainer);
        layout.putConstraint(SpringLayout.SOUTH, eventComboBox, 20, SpringLayout.NORTH, eventComboBox);
        layout.putConstraint(SpringLayout.EAST, eventComboBox, -20, SpringLayout.WEST, eventLabel);
        layout.putConstraint(SpringLayout.NORTH, eventLabel, 20, SpringLayout.SOUTH, headScrollPane);
        layout.putConstraint(SpringLayout.WEST, eventLabel, width2, SpringLayout.WEST, editOrderContainer);
        layout.putConstraint(SpringLayout.NORTH, eventScrollPane, 20, SpringLayout.SOUTH, headScrollPane);
        layout.putConstraint(SpringLayout.WEST, eventScrollPane, 0, SpringLayout.WEST,headScrollPane);
        layout.putConstraint(SpringLayout.NORTH, responsibleManLabel, 5, SpringLayout.SOUTH, eventScrollPane);
        layout.putConstraint(SpringLayout.WEST, responsibleManLabel, width2, SpringLayout.WEST, editCorrespondentContainer);
        layout.putConstraint(SpringLayout.NORTH, responsibleManScrollPane, 5, SpringLayout.SOUTH, eventScrollPane);
        layout.putConstraint(SpringLayout.WEST, responsibleManScrollPane, 0, SpringLayout.WEST, eventScrollPane);
        layout.putConstraint(SpringLayout.NORTH, dateEventLabel, 5, SpringLayout.SOUTH, responsibleManScrollPane);
        layout.putConstraint(SpringLayout.WEST, dateEventLabel, width2, SpringLayout.WEST, editOrderContainer);
        layout.putConstraint(SpringLayout.NORTH, dateEventTextField, 5, SpringLayout.SOUTH, responsibleManScrollPane);
        layout.putConstraint(SpringLayout.WEST, dateEventTextField, 0, SpringLayout.WEST, responsibleManScrollPane);
        layout.putConstraint(SpringLayout.NORTH, markLabel, 5, SpringLayout.SOUTH, dateEventTextField);
        layout.putConstraint(SpringLayout.WEST, markLabel, width2, SpringLayout.WEST, editCorrespondentContainer);
        layout.putConstraint(SpringLayout.NORTH, markComboBox, 5, SpringLayout.SOUTH, dateEventTextField);
        layout.putConstraint(SpringLayout.WEST, markComboBox, 0, SpringLayout.WEST, dateEventTextField);
        layout.putConstraint(SpringLayout.NORTH, editOrderButton, 5, SpringLayout.SOUTH, markComboBox);
        layout.putConstraint(SpringLayout.WEST, editOrderButton, width1+50, SpringLayout.WEST, editOrderContainer);

        layout.putConstraint(SpringLayout.WEST, correspondentComboBox, 5, SpringLayout.WEST, fioTextField);
        layout.putConstraint(SpringLayout.EAST, correspondentComboBox, 5, SpringLayout.EAST, fioTextField);
        layout.putConstraint(SpringLayout.NORTH, correspondentComboBox, 160, SpringLayout.NORTH, editCorrespondentContainer);
        layout.putConstraint(SpringLayout.NORTH, fioLabel, 200, SpringLayout.NORTH, editCorrespondentContainer);
        layout.putConstraint(SpringLayout.WEST, fioLabel, width2, SpringLayout.WEST, editCorrespondentContainer);
        layout.putConstraint(SpringLayout.NORTH, fioTextField,200, SpringLayout.NORTH, editCorrespondentContainer);
        layout.putConstraint(SpringLayout.WEST, fioTextField, width1, SpringLayout.WEST, editCorrespondentContainer);
        layout.putConstraint(SpringLayout.NORTH, positionLabel, 5, SpringLayout.SOUTH, fioTextField);
        layout.putConstraint(SpringLayout.WEST, positionLabel, 0, SpringLayout.WEST, fioLabel);
        layout.putConstraint(SpringLayout.NORTH, positionTextField, 5, SpringLayout.SOUTH, fioTextField);
        layout.putConstraint(SpringLayout.WEST, positionTextField, 0, SpringLayout.WEST, fioTextField);
        layout.putConstraint(SpringLayout.NORTH, divisionLabel, 5, SpringLayout.SOUTH, positionTextField);
        layout.putConstraint(SpringLayout.WEST, divisionLabel, 0, SpringLayout.WEST, positionLabel);
        layout.putConstraint(SpringLayout.NORTH, divisionTextField, 5, SpringLayout.SOUTH, positionTextField);
        layout.putConstraint(SpringLayout.WEST, divisionTextField, 0, SpringLayout.WEST, positionTextField);
        layout.putConstraint(SpringLayout.NORTH, editCorrespondentButton, 10, SpringLayout.SOUTH, divisionTextField);
        layout.putConstraint(SpringLayout.WEST, editCorrespondentButton, 50, SpringLayout.WEST, divisionTextField);

        tabbedPane.addTab("Приказ", editOrderContainer);
        tabbedPane.addTab("Корреспондент", editCorrespondentContainer);

        JPanel grid = new JPanel();
        GridLayout layout = new GridLayout(1, 2, 5, 12);
        grid.setLayout(layout);
        grid.add(editOrderContainer);
        grid.add(editCorrespondentContainer);
        getContentPane().add(grid);
        setVisible(true);
        orderComboBox.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                numberLabel.setForeground(Color.BLACK);
                dateLabel.setForeground(Color.BLACK);
                dateTextField.setEnabled(true);
                contentLabel.setForeground(Color.BLACK);
                contentTextArea.setEnabled(true);
                headLabel.setForeground(Color.BLACK);
                headTextArea.setEnabled(true);
                eventComboBox.setEnabled(true);
                ArrayList<String> information=controller.getInformationAboutOrder((String) orderComboBox.getSelectedItem());
                numberTextField.setText(information.get(0));
                dateTextField.setText(information.get(1));
                contentTextArea.setText(information.get(2));
                headTextArea.setText(information.get(3));
                String[] listEvents=controller.getListEvents(numberTextField.getText());
                eventComboBox.setModel(new DefaultComboBoxModel(listEvents));
            }
        });
        eventComboBox.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                eventLabel.setForeground(Color.BLACK);
                eventTextArea.setEnabled(true);
                responsibleManLabel.setForeground(Color.BLACK);
                responsibleManTextArea.setEnabled(true);
                dateEventLabel.setForeground(Color.BLACK);
                dateEventTextField.setEnabled(true);
                markLabel.setForeground(Color.BLACK);
                markComboBox.setEnabled(true);
                ArrayList<String> information=controller.getInformationAboutEvent((String)eventComboBox.getSelectedItem());
                eventTextArea.setText(information.get(0));
                responsibleManTextArea.setText(information.get(3));
                dateEventTextField.setText(information.get(1));
                if(information.get(2).equals("Y"))
                    markComboBox.setSelectedIndex(0);
                else
                    markComboBox.setSelectedIndex(1);
                editOrderButton.setEnabled(true);
            }
        });
        correspondentComboBox.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                fioLabel.setForeground(Color.BLACK);
                positionLabel.setForeground(Color.BLACK);
                divisionLabel.setForeground(Color.BLACK);
                fioTextField.setEnabled(true);
                positionTextField.setEnabled(true);
                divisionTextField.setEnabled(true);
                editCorrespondentButton.setEnabled(true);
                ArrayList<String> information=controller.getInformationAboutCorr((String) correspondentComboBox.getSelectedItem());
                fioTextField.setText(information.get(0));
                positionTextField.setText(information.get(1));
                divisionTextField.setText(information.get(2));
            }
        });
        editOrderButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                boolean answer=true;
                String number=numberTextField.getText();
                String date=dateTextField.getText();
                String content=contentTextArea.getText();
                String head=headTextArea.getText().split("\n")[0];
                String event=eventTextArea.getText();
                String responsibleMan=responsibleManTextArea.getText();
                String dateEvent=dateEventTextField.getText();
                String mark=markComboBox.getSelectedItem()=="Да"? "Y":"N";
                answer=controller.changeOrder(number, date, content, head, event, responsibleMan, dateEvent, mark);
                if(answer=false)
                    showErrorMessage();
                else
                {
                    numberLabel.setForeground(Color.GRAY);
                    numberTextField.setText("");
                    dateLabel.setForeground(Color.GRAY);
                    dateTextField.setEnabled(false);
                    dateTextField.setText("");
                    contentLabel.setForeground(Color.GRAY);
                    contentTextArea.setEnabled(false);
                    contentTextArea.setText("");
                    headLabel.setForeground(Color.GRAY);
                    headTextArea.setEnabled(false);
                    headTextArea.setText("ФИО\nподразделение\nдолжность");
                    eventComboBox.setEnabled(false);
                    eventComboBox.setModel(new DefaultComboBoxModel());
                    eventLabel.setForeground(Color.GRAY);
                    eventTextArea.setEnabled(false);
                    eventTextArea.setText("");
                    responsibleManLabel.setForeground(Color.GRAY);
                    responsibleManTextArea.setEnabled(false);
                    responsibleManTextArea.setText("");
                    dateEventLabel.setForeground(Color.GRAY);
                    dateEventTextField.setEnabled(false);
                    dateEventTextField.setText("");
                    markLabel.setForeground(Color.GRAY);
                    markComboBox.setSelectedIndex(0);
                    markComboBox.setEnabled(false);
                    editCorrespondentButton.setEnabled(false);
                }
            }
        });
        editCorrespondentButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String oldfio=(String)correspondentComboBox.getSelectedItem();
                String fio=fioTextField.getText();
                String position=positionTextField.getText();
                String division=divisionTextField.getText();
                boolean answer=controller.changeCorrespondent(oldfio, fio, division, position);
                if(answer==false)
                    showErrorMessage();
                else
                {
                    if(!fio.equals(oldfio))
                    {
                        int index=correspondentComboBoxModel.getIndexOf(correspondentComboBoxModel.getSelectedItem());
                        correspondentComboBoxModel.removeElementAt(index);
                        correspondentComboBoxModel.insertElementAt(fio, index);
                        correspondentComboBoxModel.setSelectedItem(fio);
                    }
                    fioLabel.setForeground(Color.GRAY);
                    positionLabel.setForeground(Color.GRAY);
                    divisionLabel.setForeground(Color.GRAY);
                    fioTextField.setText("");
                    positionTextField.setText("");
                    divisionTextField.setText("");
                    fioTextField.setEnabled(false);
                    positionTextField.setEnabled(false);
                    divisionTextField.setEnabled(false);
                    editCorrespondentButton.setEnabled(false);
                }
            }
        });

        mainContainer.add(tabbedPane);

        revalidate();
        repaint();
    }

    private void deleteData()
    {
        JTabbedPane tabbedPane=new JTabbedPane();

        Container deleteOrderContainer=new Container();
        Container deleteCorrespondentContainer=new Container();

        deleteOrderContainer.setLayout(layout);
        deleteCorrespondentContainer.setLayout(layout);

        JLabel numberLabel=new JLabel("Номер приказа:");
        numberLabel.setForeground(Color.BLACK);

        JButton deleteOrderButton=new JButton("Удалить");
        deleteOrderButton.setEnabled(false);
        JButton deleteCorrespondentButton=new JButton("Удалить");
        deleteCorrespondentButton.setEnabled(false);

        JComboBox orderComboBox=new JComboBox(controller.getListOrders());
        JComboBox correspondentComboBox=new JComboBox(controller.getListCorrespondents());
        JComboBox eventComboBox=new JComboBox();
        eventComboBox.setEnabled(false);
        eventComboBox.setPreferredSize(new Dimension(0, 20));

        deleteOrderContainer.add(numberLabel);
        deleteOrderContainer.add(orderComboBox);
        deleteOrderContainer.add(deleteOrderButton);
        deleteOrderContainer.add(eventComboBox);
        deleteCorrespondentContainer.add(correspondentComboBox);
        deleteCorrespondentContainer.add(deleteCorrespondentButton);

        layout.putConstraint(SpringLayout.NORTH, numberLabel, 150, SpringLayout.NORTH, deleteOrderContainer);
        layout.putConstraint(SpringLayout.WEST, numberLabel, 300, SpringLayout.WEST, deleteOrderContainer);
        layout.putConstraint(SpringLayout.NORTH, orderComboBox, 0, SpringLayout.NORTH, numberLabel);
        layout.putConstraint(SpringLayout.WEST, orderComboBox, 5, SpringLayout.EAST, numberLabel);
        layout.putConstraint(SpringLayout.SOUTH, orderComboBox, 0, SpringLayout.SOUTH, numberLabel);
        layout.putConstraint(SpringLayout.NORTH, eventComboBox, 10, SpringLayout.SOUTH, numberLabel);
        layout.putConstraint(SpringLayout.WEST, eventComboBox, 0, SpringLayout.WEST, numberLabel);
        layout.putConstraint(SpringLayout.EAST, eventComboBox, 0, SpringLayout.EAST, orderComboBox);
        layout.putConstraint(SpringLayout.NORTH, deleteOrderButton, 10, SpringLayout.SOUTH, eventComboBox);
        layout.putConstraint(SpringLayout.WEST, deleteOrderButton, 25, SpringLayout.WEST, eventComboBox);

        layout.putConstraint(SpringLayout.NORTH, correspondentComboBox, 180, SpringLayout.NORTH, deleteCorrespondentContainer);
        layout.putConstraint(SpringLayout.WEST, correspondentComboBox, 280, SpringLayout.WEST, deleteCorrespondentContainer);
        layout.putConstraint(SpringLayout.NORTH, deleteCorrespondentButton, 10, SpringLayout.SOUTH, correspondentComboBox);
        layout.putConstraint(SpringLayout.WEST, deleteCorrespondentButton, 60, SpringLayout.WEST, correspondentComboBox);

        orderComboBox.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String[] events=controller.getListEvents((String) orderComboBox.getSelectedItem());
                String[] optionsToChoose=new String[events.length+2];
                optionsToChoose[0]="Удалить приказ";
                optionsToChoose[1]="Удалить мероприятия";
                if(events.length!=0)
                    for(int i=2; i<optionsToChoose.length; i++)
                        optionsToChoose[i]=events[i-2];
                eventComboBox.setModel(new DefaultComboBoxModel(optionsToChoose));
                eventComboBox.setEnabled(true);
            }
        });
        eventComboBox.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                deleteOrderButton.setEnabled(true);
            }
        });
        deleteOrderButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                boolean answer=false;
                String choice=(String)eventComboBox.getSelectedItem();
                if(choice.equals("Удалить приказ"))
                    answer=controller.deleteOrder((String) orderComboBox.getSelectedItem());
                else
                if(choice.equals("Удалить мероприятия"))
                    answer=controller.deleteAllEvents((String) orderComboBox.getSelectedItem());
                else
                    answer=controller.deleteEvent((String) eventComboBox.getSelectedItem());
                if(answer==false)
                    showErrorMessage();
                else
                {
                    orderComboBox.setModel(new DefaultComboBoxModel(controller.getListOrders()));
                    eventComboBox.setModel(new DefaultComboBoxModel());
                    eventComboBox.setEnabled(false);
                    deleteOrderButton.setEnabled(false);
                }
            }
        });
        correspondentComboBox.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                deleteCorrespondentButton.setEnabled(true);
            }
        });
        deleteCorrespondentButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                boolean answer=controller.deleteCorrespondent((String)correspondentComboBox.getSelectedItem());
                if(answer==false)
                    showErrorMessage();
                else
                {
                    correspondentComboBox.setModel(new DefaultComboBoxModel(controller.getListCorrespondents()));
                    deleteCorrespondentButton.setEnabled(false);
                }
            }
        });

        JPanel grid = new JPanel();
        GridLayout layout = new GridLayout(1, 3, 5, 12);
        grid.setLayout(layout);
        grid.add(deleteOrderContainer);
        grid.add(deleteCorrespondentContainer);
        getContentPane().add(grid);
        setVisible(true);
        mainContainer.add(tabbedPane);

        revalidate();
        repaint();
    }

    private void searchData()
    {
        JTabbedPane tabbedPane=new JTabbedPane();

        Container firstSearchContainer=new Container();
        Container secondSearchContainer=new Container();
        Container thirdSearchContainer=new Container();

        firstSearchContainer.setLayout(layout);
        secondSearchContainer.setLayout(layout);
        thirdSearchContainer.setLayout(layout);

        JLabel dateBeginLabel=new JLabel("Дата начала:");
        JLabel dateEndLabel=new JLabel("Дата завершения:");
        JLabel typeOfDocumentLabel=new JLabel("Тип документа:");
        JLabel currentDateLabel=new JLabel("Текущая дата:");
        JLabel fixedDateLabel=new JLabel("Заданная дата:");

        JTextField dateBeginTextField=new JTextField("ГГГГ-ММ-ДД", 7);
        JTextField dateEndTextField=new JTextField("ГГГГ-ММ-ДД", 7);
        JTextField currentDateTextField=new JTextField("ГГГГ-ММ-ДД",7);
        JTextField fixedDateTextField=new JTextField("ГГГГ-ММ-ДД",7);

        JButton firstSearchButton=new JButton("Поиск");
        JButton secondSearchButton=new JButton("Поиск");
        JButton thirdSearchButton=new JButton("Вывести");
        secondSearchButton.setEnabled(false);

        JComboBox typeOfDocumentComboBox=new JComboBox(new String[]{"Приказ", "Мероприятие"});
        typeOfDocumentComboBox.setPreferredSize(new Dimension(100,20));

        firstSearchContainer.add(dateBeginLabel);
        firstSearchContainer.add(dateEndLabel);
        firstSearchContainer.add(dateBeginTextField);
        firstSearchContainer.add(dateEndTextField);
        firstSearchContainer.add(firstSearchButton);
        secondSearchContainer.add(typeOfDocumentLabel);
        secondSearchContainer.add(typeOfDocumentComboBox);
        secondSearchContainer.add(currentDateLabel);
        secondSearchContainer.add(currentDateTextField);
        secondSearchContainer.add(secondSearchButton);
        thirdSearchContainer.add(fixedDateLabel);
        thirdSearchContainer.add(fixedDateTextField);
        thirdSearchContainer.add(thirdSearchButton);

        layout.putConstraint(SpringLayout.NORTH, dateBeginLabel, 20, SpringLayout.NORTH, firstSearchContainer);
        layout.putConstraint(SpringLayout.WEST, dateBeginLabel, 20, SpringLayout.WEST, firstSearchContainer);
        layout.putConstraint(SpringLayout.WEST, dateBeginTextField, 5, SpringLayout.EAST, dateBeginLabel);
        layout.putConstraint(SpringLayout.NORTH, dateBeginTextField, 0, SpringLayout.NORTH, dateBeginLabel);
        layout.putConstraint(SpringLayout.NORTH, dateEndTextField, 20, SpringLayout.NORTH, firstSearchContainer);
        layout.putConstraint(SpringLayout.EAST, dateEndTextField, -15, SpringLayout.EAST, firstSearchContainer);
        layout.putConstraint(SpringLayout.EAST, dateEndLabel, -10, SpringLayout.WEST, dateEndTextField);
        layout.putConstraint(SpringLayout.NORTH, dateEndLabel, 0, SpringLayout.NORTH, dateEndTextField);
        layout.putConstraint(SpringLayout.NORTH, firstSearchButton,10, SpringLayout.SOUTH, dateBeginLabel);
        layout.putConstraint(SpringLayout.WEST, firstSearchButton, 25, SpringLayout.EAST, dateBeginTextField);

        layout.putConstraint(SpringLayout.NORTH, typeOfDocumentLabel, 40, SpringLayout.NORTH, secondSearchContainer);
        layout.putConstraint(SpringLayout.WEST, typeOfDocumentLabel, 100, SpringLayout.WEST, secondSearchContainer);
        layout.putConstraint(SpringLayout.NORTH, typeOfDocumentComboBox, 0, SpringLayout.NORTH, typeOfDocumentLabel);
        layout.putConstraint(SpringLayout.WEST, typeOfDocumentComboBox, 5, SpringLayout.EAST, typeOfDocumentLabel);
        layout.putConstraint(SpringLayout.NORTH, currentDateLabel,10, SpringLayout.SOUTH, typeOfDocumentComboBox);
        layout.putConstraint(SpringLayout.WEST, currentDateLabel, 0, SpringLayout.WEST, typeOfDocumentLabel);
        layout.putConstraint(SpringLayout.NORTH, currentDateTextField, 0, SpringLayout.NORTH, currentDateLabel);
        layout.putConstraint(SpringLayout.WEST, currentDateTextField, 0, SpringLayout.WEST, typeOfDocumentComboBox);
        layout.putConstraint(SpringLayout.EAST, currentDateTextField, 0, SpringLayout.EAST, typeOfDocumentComboBox);
        layout.putConstraint(SpringLayout.NORTH, secondSearchButton, 10, SpringLayout.SOUTH, currentDateTextField);
        layout.putConstraint(SpringLayout.WEST, secondSearchButton, 50, SpringLayout.WEST, currentDateLabel);


        layout.putConstraint(SpringLayout.NORTH, fixedDateLabel, 40, SpringLayout.NORTH, thirdSearchContainer);
        layout.putConstraint(SpringLayout.WEST, fixedDateLabel, 100, SpringLayout.WEST, thirdSearchContainer);
        layout.putConstraint(SpringLayout.NORTH, fixedDateTextField,0, SpringLayout.NORTH, fixedDateLabel);
        layout.putConstraint(SpringLayout.NORTH, fixedDateTextField,0, SpringLayout.NORTH, fixedDateLabel);
        layout.putConstraint(SpringLayout.WEST, fixedDateTextField, 200, SpringLayout.WEST, thirdSearchContainer);
        layout.putConstraint(SpringLayout.EAST, thirdSearchButton, 230, SpringLayout.WEST, thirdSearchContainer);
        layout.putConstraint(SpringLayout.NORTH, thirdSearchButton, 70, SpringLayout.NORTH, thirdSearchContainer);


        typeOfDocumentComboBox.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                secondSearchButton.setEnabled(true);
            }
        });

        firstSearchButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String[] data=controller.getListEvents(dateBeginTextField.getText(), dateEndTextField.getText());
                Object[][] eventTableDate=new Object[data.length/4][];
                for(int i=0; i<eventTableDate.length; i++)
                {
                    Object[] currentEvent=new Object[4];
                    for(int j=0; j<4; j++)
                    {
                        currentEvent[j] = data[i * 4 + j];
                        if(currentEvent[j].equals("Y"))
                            currentEvent[j]="Да";
                        else if(currentEvent[j].equals("N"))
                            currentEvent[j]="Нет";
                    }
                    eventTableDate[i]=currentEvent;
                }
                String[] eventTableColumnName={"Мероприятие", "Дата", "Выполнено", "Ответственный"};
                JTable eventTable=new JTable(eventTableDate, eventTableColumnName);
                eventTable.setRowSelectionAllowed(false);
                eventTable.setColumnSelectionAllowed(false);
                JScrollPane eventTableScrollPane=new JScrollPane(eventTable);
                firstSearchContainer.add(eventTableScrollPane);
                layout.putConstraint(SpringLayout.NORTH, eventTableScrollPane, 20, SpringLayout.SOUTH, firstSearchButton);
                layout.putConstraint(SpringLayout.EAST, eventTableScrollPane, 0, SpringLayout.EAST, firstSearchContainer);
                layout.putConstraint(SpringLayout.WEST, eventTableScrollPane, 0, SpringLayout.WEST, firstSearchContainer);
                layout.putConstraint(SpringLayout.SOUTH, eventTableScrollPane, 0, SpringLayout.SOUTH, firstSearchContainer);
                revalidate();
                repaint();
            }
        });
        secondSearchButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                String choice=(String) typeOfDocumentComboBox.getSelectedItem();
                String[] data=choice.equals("Приказ")?
                        controller.getListOrders(currentDateTextField.getText()):
                        controller.getListEvents(currentDateTextField.getText(), 0);
                Object[][] tableDate=new Object[data.length/4][];
                for(int i=0; i<tableDate.length; i++)
                {
                    Object[] currentEvent=new Object[4];
                    for (int j = 0; j < 4; j++)
                    {
                        currentEvent[j] = data[i * 4 + j];
                        if (currentEvent[j].equals("Y"))
                            currentEvent[j] = "Да";
                        else if (currentEvent[j].equals("N"))
                            currentEvent[j] = "Нет";
                    }
                    tableDate[i]=currentEvent;
                }
                String[] orderTableColumnName={"Номер", "Дата", "Содержание", "Принял"};
                String[] eventTableColumnName={"Мероприятие", "Дата", "Выполнено", "Ответственный"};
                JTable table=choice.equals("Приказ")?
                        new JTable(tableDate, orderTableColumnName):
                        new JTable(tableDate, eventTableColumnName);
                table.setRowSelectionAllowed(false);
                table.setColumnSelectionAllowed(false);
                JScrollPane tableScrollPane=new JScrollPane(table);

              // layout.putConstraint(SpringLayout.NORTH, tableScrollPane, 20, SpringLayout.SOUTH, secondSearchButton);
              // layout.putConstraint(SpringLayout.EAST, tableScrollPane, 1, SpringLayout.EAST, firstSearchContainer);
              // layout.putConstraint(SpringLayout.WEST, tableScrollPane, 1, SpringLayout.WEST, firstSearchContainer);
               //layout.putConstraint(SpringLayout.SOUTH, tableScrollPane, 1, SpringLayout.SOUTH, firstSearchContainer);

                JFrame frame = new JFrame("Test frame");
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                JLabel label = new JLabel("Test label");
                frame.getContentPane().add(label);
                frame.setPreferredSize(new Dimension(800, 600));
                frame.pack();
                frame.setVisible(true);
                frame.add(tableScrollPane);

                revalidate();
                repaint();
            }
        });

        thirdSearchButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {

                String[] data=controller.getListCorrespondents(fixedDateTextField.getText());
                Object[][] corrTableDate=new Object[data.length/7][];
                for(int i=0; i<corrTableDate.length; i++)
                {
                    Object[] currentEvent=new Object[7];
                    for(int j=0; j<7; j++)
                    {
                        currentEvent[j] = data[i * 7 + j];
                        if(currentEvent[j].equals("Y"))
                            currentEvent[j]="Да";
                        else if(currentEvent[j].equals("N"))
                            currentEvent[j]="Нет";
                    }
                    corrTableDate[i]=currentEvent;
                }
                String[] corrTableColumnName={"Дата приказа", "Мероприятие", "Выполнено", "Дата выполнения", "Ответсвенный", "Должность", "Подразделение"};
                JTable corrTable=new JTable(corrTableDate, corrTableColumnName);
                corrTable.setRowSelectionAllowed(false);
                corrTable.setColumnSelectionAllowed(false);
                JScrollPane corrTableScrollPane=new JScrollPane(corrTable);
                thirdSearchContainer.add(corrTableScrollPane);
                layout.putConstraint(SpringLayout.NORTH, corrTableScrollPane, 20, SpringLayout.SOUTH, thirdSearchButton);
                layout.putConstraint(SpringLayout.EAST, corrTableScrollPane, 0, SpringLayout.EAST, thirdSearchContainer);
                layout.putConstraint(SpringLayout.WEST, corrTableScrollPane, 0, SpringLayout.WEST, thirdSearchContainer);
                layout.putConstraint(SpringLayout.SOUTH, corrTableScrollPane, 0, SpringLayout.SOUTH, thirdSearchContainer);
                revalidate();
                repaint();
            }
        });


        JPanel grid = new JPanel();
        GridLayout layout = new GridLayout(1, 3, 5, 12);
        grid.setLayout(layout);
        grid.add(firstSearchContainer);
        grid.add(secondSearchContainer);
        grid.add(thirdSearchContainer);
        getContentPane().add(grid);
        setVisible(true);

        revalidate();
        repaint();
    }

    private void showErrorMessage()
    {
        JOptionPane.showMessageDialog(this,"Проверьте правильность ввода данных.","Ошибка", JOptionPane.ERROR_MESSAGE);
    }
}