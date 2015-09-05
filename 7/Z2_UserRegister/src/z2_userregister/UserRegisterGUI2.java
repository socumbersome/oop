/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package z2_userregister;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author ja
 */
public class UserRegisterGUI2 extends JFrame implements ActionListener {
    
    private static String ADD_COMMAND = "add";
    private static String CHANGE_COMMAND = "change";
    private UsersDatabase db;
    EventAggregator eaggregator;
    
    public UserRegisterGUI2(UsersDatabase db, EventAggregator eaggregator) {
        this.eaggregator = eaggregator;
        this.db = db;
        initComponents();
        setVisible(true);
    }
    
    public void populateTree() {

        DefaultMutableTreeNode stud, lect;

        stud = dynamicTree.addObject(null, "Students");
        lect = dynamicTree.addObject(null, "Lecturers");
        
        for(Person p : db.students) {
            dynamicTree.addObject(stud, p);
        }
        
        for(Person p : db.lecturers) {
            dynamicTree.addObject(lect, p);
        }
    }
    
    private void initComponents() {
        
        jScrollPane1 = new javax.swing.JScrollPane();
        UsersListView = new ListView();
        
        
        eaggregator.addSubscriber(UsersListView, RefreshUI.class);
        
        
        AddButton = new javax.swing.JButton();
        ChangeButton = new javax.swing.JButton();
        UsersTreeView = new javax.swing.JPanel();
        dynamicTree = new DynamicTree(eaggregator);
        dynamicTree.setPreferredSize(new Dimension(300, 150));
        populateTree();
        listModel = new UsersListModel(db, eaggregator);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        
        eaggregator.addSubscriber(listModel, Category.class);
        eaggregator.addSubscriber(listModel, Persona.class);
        
        UsersListView.setModel(listModel);
        jScrollPane1.setViewportView(UsersListView);

        AddButton.setText("Add");
        AddButton.setActionCommand(ADD_COMMAND);
        AddButton.addActionListener(this);

        ChangeButton.setText("Change");
        ChangeButton.setActionCommand(CHANGE_COMMAND);
        ChangeButton.addActionListener(this);

        javax.swing.GroupLayout UsersTreeViewLayout = new javax.swing.GroupLayout(UsersTreeView);
        UsersTreeView.setLayout(UsersTreeViewLayout);
        UsersTreeViewLayout.setHorizontalGroup(
            UsersTreeViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 184, Short.MAX_VALUE)
            .addComponent(dynamicTree)
        );
        UsersTreeViewLayout.setVerticalGroup(
            UsersTreeViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(dynamicTree)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(UsersTreeView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(AddButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ChangeButton)
                        .addGap(0, 451, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AddButton)
                            .addComponent(ChangeButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE))
                    .addComponent(UsersTreeView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }
    
    UsersListModel listModel;

    private javax.swing.JScrollPane jScrollPane1;

    private javax.swing.JButton AddButton;
    private javax.swing.JButton ChangeButton;
    private ListView UsersListView;
    private javax.swing.JPanel UsersTreeView;
    private DynamicTree dynamicTree;

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
    //    System.out.println(command + "!");
        
        if (ADD_COMMAND.equals(command)) {
            //Add button clicked
            Person p = new Person("aaa", "bbb", "02.03.1999", "cccc", "ddddd");
            db.addStudent(p);
            db.addLecturer(p);
            dynamicTree.addObject(p);
            //db.addStudent(p);
        } else if (CHANGE_COMMAND.equals(command)) {
            
        }
    }
}
