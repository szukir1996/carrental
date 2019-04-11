package view;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import entity.Car;
import model.CarTableModel;
import entity.Client;
import database.ConnectionFactory;
import entity.Rental;
import exception.InvalidInputException;
import exception.LicenseplateException;
import java.text.DateFormat;
import model.ClientTableModel;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import model.RentalController;
import model.RentalTableModel;



public class MainWindow extends javax.swing.JFrame {
    
    private CarTableModel carTableModel;
    private ClientTableModel clientTableModel;
    private RentalTableModel rentalTableModel;

    public MainWindow(){
        carTableModel = new CarTableModel();
        clientTableModel = new ClientTableModel();
        rentalTableModel = new RentalTableModel();
        setTitle("Autókölcsönző");
        initComponents();
        
        tableClient.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                if(tableClient.getSelectedRow() != -1){
                    int row = tableClient.getSelectedRow();
                    clientID.setText(clientTableModel.getValueAt(row, 0).toString());
                }else{
                }
            }
        });
        
        tableCar.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                if(tableCar.getSelectedRow() != -1){
                    int row = tableCar.getSelectedRow();
                    carID.setText(carTableModel.getValueAt(row,0).toString());
                    editDailyFee.setText(carTableModel.getValueAt(row, 5).toString());
                    editLastService.setText(carTableModel.getValueAt(row, 6).toString());
                    if(carTableModel.getValueAt(row, 7).toString().equals("1")){
                        editInService.setSelected(true);
                    }else{
                        editInService.setSelected(false);
                    }
                }else{
                }
            }
        });
        
        tableRental.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                if(tableRental.getSelectedRow() != -1){
                    int row = tableRental.getSelectedRow();
                    rentalID.setText(rentalTableModel.getValueAt(row, 0).toString());
                    plateNumber.setText(rentalTableModel.getValueAt(row, 2).toString());
                }else{
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        clientName = new javax.swing.JTextField();
        clientAddress = new javax.swing.JTextField();
        clientPhoneNumber = new javax.swing.JTextField();
        clientAddButton = new javax.swing.JButton();
        licensePlate = new javax.swing.JTextField();
        dailyFee = new javax.swing.JTextField();
        type = new javax.swing.JTextField();
        lastService = new javax.swing.JTextField();
        brand = new javax.swing.JTextField();
        yearOfManufacture = new javax.swing.JTextField();
        carAddButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCar = new javax.swing.JTable();
        inService = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        editDailyFee = new javax.swing.JTextField();
        editLastService = new javax.swing.JTextField();
        editInService = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        editDone = new javax.swing.JButton();
        carID = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableClient = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        newRent = new javax.swing.JButton();
        endRental = new javax.swing.JButton();
        rentalEnd = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        clientID = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableRental = new javax.swing.JTable();
        rentalID = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        backDate = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        activeRental = new javax.swing.JButton();
        inactiveRental = new javax.swing.JButton();
        allRental = new javax.swing.JButton();
        plateNumber = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        filter = new javax.swing.JTextField();
        filterButton = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();

        jButton1.setText("Összes");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        clientName.setToolTipText("");

        clientAddress.setToolTipText("");

        clientPhoneNumber.setToolTipText("");
        clientPhoneNumber.setName(""); // NOI18N
        clientPhoneNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientPhoneNumberActionPerformed(evt);
            }
        });

        clientAddButton.setText("Ügyfél felvétel");
        clientAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientAddButtonActionPerformed(evt);
            }
        });

        carAddButton.setText("Autó felvétel");
        carAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carAddButtonActionPerformed(evt);
            }
        });

        tableCar.setModel(carTableModel);
        tableCar.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tableCar);

        inService.setText("Szervizben van-e");
        inService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inServiceActionPerformed(evt);
            }
        });

        jLabel1.setText("Név");

        jLabel2.setText("Lakcím");

        jLabel3.setText("Telefonszám");

        jLabel4.setText("Rendszám");

        jLabel5.setText("Napi bérleti díj");

        jLabel6.setText("Utolsó szervizelés dátuma");

        jLabel7.setText("Évjárat");

        jLabel8.setText("Típus");

        jLabel9.setText("Márka");

        editInService.setText("Szervizben van-e");

        jLabel10.setText("Napi bérleti díj");

        jLabel11.setText("Utolsó szervizelés dátuma");

        editDone.setText("Módosítás");
        editDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editDoneActionPerformed(evt);
            }
        });

        carID.setEditable(false);
        carID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carIDActionPerformed(evt);
            }
        });

        jLabel12.setText("ID");

        tableClient.setModel(clientTableModel);
        jScrollPane2.setViewportView(tableClient);

        jLabel13.setText("Ügyfelek");

        jLabel14.setText("Kölcsönzés");

        newRent.setText("Új kölcsönzés");
        newRent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newRentActionPerformed(evt);
            }
        });

        endRental.setText("Kölcsönzés lezárása");
        endRental.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endRentalActionPerformed(evt);
            }
        });

        jLabel15.setText("Terv. lejárati. dát.");

        clientID.setEditable(false);
        clientID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientIDActionPerformed(evt);
            }
        });

        jLabel16.setText("ID");

        tableRental.setModel(rentalTableModel);
        jScrollPane3.setViewportView(tableRental);

        rentalID.setEditable(false);

        jLabel17.setText("ID");

        backDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backDateActionPerformed(evt);
            }
        });

        jLabel18.setText("Visszahozott dátum");

        activeRental.setText("Aktív");
        activeRental.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activeRentalActionPerformed(evt);
            }
        });

        inactiveRental.setText("Befejezett");
        inactiveRental.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inactiveRentalActionPerformed(evt);
            }
        });

        allRental.setText("Összes");
        allRental.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allRentalActionPerformed(evt);
            }
        });

        plateNumber.setEditable(false);

        jLabel19.setText("Rendszám");

        filterButton.setText("Rendezés");
        filterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterButtonActionPerformed(evt);
            }
        });

        jLabel20.setText("Rendezés rendszám/ügyfélnév szerint");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(81, 81, 81)
                                .addComponent(jLabel9))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(licensePlate, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(brand, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(yearOfManufacture, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dailyFee, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(lastService, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(inService)
                                .addGap(18, 18, 18)
                                .addComponent(carAddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 185, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10)
                                .addGap(109, 109, 109))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(carID, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(editDailyFee, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(editLastService, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(editInService)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editDone))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(clientName, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(clientAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(clientPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(clientAddButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(clientID, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(148, 148, 148)
                                .addComponent(jLabel2)
                                .addGap(102, 102, 102)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel16))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(rentalEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(newRent))
                                            .addComponent(jLabel15))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel20)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel18)
                                                .addGap(7, 7, 7))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(filter, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(filterButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(backDate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(endRental)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rentalID, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19)
                                    .addComponent(plateNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(allRental)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(activeRental)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inactiveRental)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9)
                    .addComponent(jLabel7)
                    .addComponent(jLabel12)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(licensePlate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(brand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yearOfManufacture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editDailyFee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel11))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dailyFee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastService, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editLastService, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editInService)
                    .addComponent(editDone)
                    .addComponent(inService)
                    .addComponent(carAddButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clientName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clientAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clientPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clientAddButton)
                    .addComponent(clientID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(allRental)
                    .addComponent(activeRental)
                    .addComponent(inactiveRental))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(jLabel20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel18)
                        .addComponent(jLabel17)
                        .addComponent(jLabel19)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newRent)
                    .addComponent(rentalEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(endRental)
                    .addComponent(plateNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rentalID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filterButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clientPhoneNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientPhoneNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clientPhoneNumberActionPerformed

    private void clientAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientAddButtonActionPerformed
        try{
            Client client = new Client(0, clientName.getText(), clientAddress.getText(), clientPhoneNumber.getText());
            client.addClient();
            JOptionPane.showMessageDialog(null, "Ügyfél felvéve az adatbázisba!");
            clientName.setText("");
            clientAddress.setText("");
            clientPhoneNumber.setText("");
            clientTableModel.LoadTable();
        }catch(InvalidInputException e){
            JOptionPane.showMessageDialog(null, "Hibás/hiányzó adat!");
            clientName.setText("");
            clientAddress.setText("");
            clientPhoneNumber.setText("");
            clientTableModel.LoadTable();
        }
        
    }//GEN-LAST:event_clientAddButtonActionPerformed

    private void carAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carAddButtonActionPerformed
        try{
            Car car = new Car(0, licensePlate.getText(), brand.getText(), type.getText(), Integer.parseInt(yearOfManufacture.getText()), dailyFee.getText(), lastService.getText(), inService.isSelected());
            if(carTableModel.checkCar(car.getLicensePlate())){
                car.addCar();
            }else{
                throw new LicenseplateException();
            }
            JOptionPane.showMessageDialog(null, "Autó felvéve az adatbázisba!");
            carTableModel.LoadTable();
            licensePlate.setText("");
            brand.setText("");
            type.setText("");
            yearOfManufacture.setText("");
            dailyFee.setText("");
            lastService.setText("");
            inService.setSelected(false);
        }catch(InvalidInputException | NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Hibás/hiányzó adat!");
        }catch (LicenseplateException ex) {
            JOptionPane.showMessageDialog(null, "Az autó már szerepel az adatbázisban!");
        }
    }//GEN-LAST:event_carAddButtonActionPerformed

    private void inServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inServiceActionPerformed

    }//GEN-LAST:event_inServiceActionPerformed

    private void editDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editDoneActionPerformed
        if(!editDailyFee.getText().isEmpty() || !editLastService.getText().isEmpty()){ 
            int result = JOptionPane.showConfirmDialog(null, "Biztosan módosítod?", "Warning" ,JOptionPane.YES_NO_OPTION);
            if(result == JOptionPane.YES_OPTION){
                String id = carID.getText();
                String temp = editDailyFee.getText();
                String temp2 = editLastService.getText();
                int temp3 = editInService.isSelected() ? 1 : 0;
                carTableModel.editCar(id, temp, temp2, temp3);
                carTableModel.fireTableDataChanged();
                carTableModel.LoadTable();
                carID.setText("");
                editDailyFee.setText("");
                editLastService.setText("");
                editInService.setSelected(false);
            }
        }
    }//GEN-LAST:event_editDoneActionPerformed

    private void carIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_carIDActionPerformed

    private void newRentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newRentActionPerformed
        if(!rentalEnd.getText().isEmpty()){
            int result = JOptionPane.showConfirmDialog(null, "Biztosan elindítod a kölcsönzést?", "Warning" ,JOptionPane.YES_NO_OPTION);
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date reportDate = Calendar.getInstance().getTime();
            String today = df.format(reportDate);
            String dateEnd = rentalEnd.getText();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate tempEnd = LocalDate.parse(dateEnd, formatter);
            LocalDate tempToday = reportDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            if(result == JOptionPane.YES_OPTION){
                try {
                    RentalController rc = new RentalController(Integer.parseInt(clientID.getText()), Integer.parseInt(carID.getText()));
                    if(rc.getInService() || !rc.checkClient(Integer.parseInt(clientID.getText())) || !rc.checkCar(rc.getPlateNumber()) || tempToday.compareTo(tempEnd) > 0){
                        JOptionPane.showMessageDialog(null, "Az autó nem kölcsönözhető!");
                        rentalEnd.setText("");
                    }else{
                        Rental rental = new Rental(rc.getClientID(), rc.getClientName(), rc.getCarID(), rc.getPlateNumber(), today, rentalEnd.getText(), "-", 0);
                        rental.addRental();
                    }
                } catch (InvalidInputException | NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Hibás/hiányzó adat!");
                }
                rentalTableModel.LoadTable(0);
                rentalEnd.setText("");
            }
        }
    }//GEN-LAST:event_newRentActionPerformed

    private void clientIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clientIDActionPerformed

    private void endRentalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endRentalActionPerformed
        int result = JOptionPane.showConfirmDialog(null, "Biztosan lezárod a kölcsönzést?", "Warning" ,JOptionPane.YES_NO_OPTION);
        if(result == JOptionPane.YES_OPTION && !backDate.getText().isEmpty()){
            RentalController rc = new RentalController(Integer.parseInt(rentalID.getText()), plateNumber.getText());
            try {
                if(rc.checkEndDate(Integer.parseInt(rentalID.getText()), backDate.getText())){
                    String query3 = "UPDATE rentals SET backdate = '" + backDate.getText() + "', payed = '" + rc.calculateFee(Integer.parseInt(rentalID.getText()), backDate.getText())
                            + "' WHERE clientid = '" + rentalID.getText() +"' AND backdate = '" + "-" + "'";
                    try {
                        Connection conn = ConnectionFactory.getConnection();
                        try (Statement stmt = conn.createStatement()) {
                            int rs = stmt.executeUpdate(query3);
                        }
                        conn.close();
                    } catch (Exception ex) {
                        System.err.println(ex.toString());
                    }
                    backDate.setText("");
                    rentalTableModel.fireTableDataChanged();
                    rentalTableModel.LoadTable(0);
                }
            } catch (InvalidInputException ex) {
                JOptionPane.showMessageDialog(null, "Hibás/hiányzó adat!");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Hibás/hiányzó adat!");
        }
    }//GEN-LAST:event_endRentalActionPerformed

    private void backDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backDateActionPerformed

    }//GEN-LAST:event_backDateActionPerformed

    private void activeRentalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activeRentalActionPerformed
        rentalTableModel.LoadTable(1);
    }//GEN-LAST:event_activeRentalActionPerformed

    private void allRentalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allRentalActionPerformed
        rentalTableModel.LoadTable(0);
    }//GEN-LAST:event_allRentalActionPerformed

    private void inactiveRentalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inactiveRentalActionPerformed
        rentalTableModel.LoadTable(2);
    }//GEN-LAST:event_inactiveRentalActionPerformed

    private void filterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterButtonActionPerformed
        rentalTableModel.LoadTable(filter.getText());
        filter.setText("");
    }//GEN-LAST:event_filterButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
                //System.out.println(info.getName());
            }
        } catch (Exception ex) {}

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton activeRental;
    private javax.swing.JButton allRental;
    private javax.swing.JTextField backDate;
    private javax.swing.JTextField brand;
    private javax.swing.JButton carAddButton;
    private javax.swing.JTextField carID;
    private javax.swing.JButton clientAddButton;
    private javax.swing.JTextField clientAddress;
    private javax.swing.JTextField clientID;
    private javax.swing.JTextField clientName;
    private javax.swing.JTextField clientPhoneNumber;
    private javax.swing.JTextField dailyFee;
    private javax.swing.JTextField editDailyFee;
    private javax.swing.JButton editDone;
    private javax.swing.JCheckBox editInService;
    private javax.swing.JTextField editLastService;
    private javax.swing.JButton endRental;
    private javax.swing.JTextField filter;
    private javax.swing.JButton filterButton;
    private javax.swing.JCheckBox inService;
    private javax.swing.JButton inactiveRental;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField lastService;
    private javax.swing.JTextField licensePlate;
    private javax.swing.JButton newRent;
    private javax.swing.JTextField plateNumber;
    private javax.swing.JTextField rentalEnd;
    private javax.swing.JTextField rentalID;
    private javax.swing.JTable tableCar;
    private javax.swing.JTable tableClient;
    private javax.swing.JTable tableRental;
    private javax.swing.JTextField type;
    private javax.swing.JTextField yearOfManufacture;
    // End of variables declaration//GEN-END:variables
}
