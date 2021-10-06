package HomeworkPlanner.MainApplication;

import HomeworkPlanner.Loading.LoadingScreen;
import HomeworkPlanner.MainApplication.ActionListeners.ActionListeners;
import HomeworkPlanner.Utils.Utilities;

import javax.swing.*;
import javax.swing.plaf.basic.DefaultMenuLayout;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Scanner;

public class Application {

    // TODO: Uncomment thing in Utilities class.

    public void openHomeworkPlanner() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        JFrame homeworkPlanner = new JFrame("Homework Planner - " + "Uncomment thing in Utilities class.");
        homeworkPlanner.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        homeworkPlanner.setResizable(false);
        Container c = homeworkPlanner.getContentPane();
        c.setLayout(null);

        addElements(c);

        homeworkPlanner.setSize(907, 654);
        homeworkPlanner.setLocationRelativeTo(null);
        homeworkPlanner.setVisible(true);
    }

    private void addElements(Container c) {
        JLabel title = new JLabel(new ImageIcon(Objects.requireNonNull(getClass().getResource("/HomeworkPlanner/images/pencil.png"))));
        title.setSize(600, 146);
        title.setLocation(150, -30);
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        title.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(c, "I do not own this image.");
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                c.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                c.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
        });
        c.add(title);

        JSeparator sep = new JSeparator(SwingConstants.HORIZONTAL);
        sep.setSize(950, 5);
        sep.setLocation(0, 100);
        c.add(sep);

        // Action listeners.
        ActionListeners als = new ActionListeners();

        // Create label:
        JLabel creationSide = new JLabel("Create");
        creationSide.setSize(100, 20);
        creationSide.setLocation(150, 125);
        creationSide.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 20));
        c.add(creationSide);

        // Create options here:
        JButton createNewSubject = new JButton("Create New Subject");
        createNewSubject.setSize(150, 40);
        createNewSubject.setLocation(100, 200);
        createNewSubject.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        createNewSubject.addActionListener(als.createSubjectListener(createNewSubject));
        c.add(createNewSubject);

        JButton createNewAssignment = new JButton("Create New Assignment");
        createNewAssignment.setSize(180, 40);
        createNewAssignment.setLocation(86, 275);
        createNewAssignment.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        c.add(createNewAssignment);

        // View options:
        JLabel viewSide = new JLabel("View");
        viewSide.setSize(100, 20);
        viewSide.setLocation(600, 125);
        viewSide.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 20));
        c.add(viewSide);

        JButton viewSubjects = new JButton("View Subjects");
        viewSubjects.setSize(150, 40);
        viewSubjects.setLocation(552, 275);
        viewSubjects.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        c.add(viewSubjects);

        JButton viewAssignments = new JButton("View Current Assignments");
        viewAssignments.setSize(200, 40);
        viewAssignments.setLocation(530, 200);
        viewAssignments.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        c.add(viewAssignments);

        JButton viewCompletedAssignments = new JButton("View Completed Assignments");
        viewCompletedAssignments.setSize(200, 40);
        viewCompletedAssignments.setLocation(530, 350);
        c.add(viewCompletedAssignments);

        // Add separator between two sections of Creation and Viewing.
        JSeparator sepSect = new JSeparator(SwingConstants.VERTICAL);
        sepSect.setSize(20, 450);
        sepSect.setLocation(445, 100);
        c.add(sepSect);

        JSeparator sepBelow = new JSeparator(SwingConstants.HORIZONTAL);
        sepBelow.setSize(990, 100);
        sepBelow.setLocation(-10, 550);
        c.add(sepBelow);

        JButton about = new JButton("About and Help");
        about.setSize(145, 30);
        about.setLocation(375, 580);
        about.addActionListener(e -> {
            if (e.getSource() == about) {
                JOptionPane.showMessageDialog(c, "<html><font size=\"+1\">This software was created by me to plan <b>homework assignments</b> with organization by subject.</font><br/>" +
                        "<b><font size=\"+2\">How to use</font></b><br/>" +
                        "<br/>" +
                        "<font size=\"+0.5\">This software is very simple. It requires you to create a subject for one of your classes.<br/>" +
                        "Then, you can create assignments and choose which subject to add it too!<br/>" +
                        "For example, I have a class called <b>Math</b>. I click the <b>Create Subject</b> button, and name it <b>Math</b>.<br/>" +
                        "I then have an <b>assignment</b> where I have to take notes on section 2.3.<br/>" +
                        "I create an assignment and choose a name, due date, teacher, estimated time needed, and the subject.<br/>" +
                        "To view and delete assignments/subjects, click the <b>View Assignment/Subject</b> depending on what you want to view.<br/>" +
                        "<br/>" +
                        "I hope you enjoy my project!</font></html>", "About and Help", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        about.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        c.add(about);

        JLabel copyright = new JLabel("Copyright (C) 2021 Wesley Stewart");
        copyright.setSize(400, 15);
        copyright.setLocation(5, 609);
        copyright.setFont(new Font(null, Font.PLAIN, 10));
        c.add(copyright);
    }

    // Temporary main method for testing the above frame.
    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException, InterruptedException {
        System.out.println("TODO: Uncomment thing in Utilities class.");

        // Before starting main application, add a "loading" thing where it shows the logo.
        LoadingScreen ls = new LoadingScreen();
        ls.loadScreen();

        // Keeps loading screen up then disposes
        Thread.sleep(3000);
        ls.frame.dispose();

        // Continues to main application
        Application app = new Application();
        app.openHomeworkPlanner();
    }
}
