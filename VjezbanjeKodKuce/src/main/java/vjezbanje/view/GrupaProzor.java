/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vjezbanje.view;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import vjezbanje.util.EdunovaException;
import vjezbanje.util.EdunovaUtil;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import vjezbanje.controller.ObradaGrupa;
import vjezbanje.controller.ObradaPolaznik;
import vjezbanje.controller.ObradaPredavac;
import vjezbanje.controller.ObradaSmjer;
import vjezbanje.model.Grupa;
import vjezbanje.model.Polaznik;
import vjezbanje.model.Predavac;
import vjezbanje.model.Smjer;

/**
 *
 * @author CP
 */
public class GrupaProzor extends javax.swing.JFrame {

    private ObradaGrupa obrada;
    private ObradaPolaznik op;

    /**
     * Creates new form SmjerProzor
     */
    public GrupaProzor() {
        initComponents();
        obrada = new ObradaGrupa();
        op = new ObradaPolaznik();
        setTitle(EdunovaUtil.getNaslov("Grupe"));
        ucitaj();
        ucitajSmjer();
        ucitajPredavac();

        DatePickerSettings dps = new DatePickerSettings(new Locale("hr", "HR"));
        dps.setFormatForDatesCommonEra("dd.MM.yyyy");
        dps.setTranslationClear("Očisti");
        dps.setTranslationToday("Danas");
        dpDatumPocetka.setSettings(dps);
        lstPolazniciUGrupi.setCellRenderer(new PrikazPolaznik());
    }

    private void ucitajSmjer() {
        DefaultComboBoxModel<Smjer> ms = new DefaultComboBoxModel<>();
        Smjer smjer = new Smjer();
        smjer.setSifra(Long.valueOf(0));
        smjer.setNaziv("Nije odabrano");
        ms.addElement(smjer);
        new ObradaSmjer().read().forEach(s -> {
            ms.addElement(s);
        });
        cmbSmjerovi.setModel(ms);
    }

    private void ucitajPredavac() {
        DefaultComboBoxModel<Predavac> ms = new DefaultComboBoxModel<>();
        Predavac predavac = new Predavac();
        predavac.setSifra(Long.valueOf(0));
        predavac.setIme("Nije");
        predavac.setPrezime("odabrano");
        ms.addElement(predavac);
        new ObradaPredavac().read().forEach(s -> {
            ms.addElement(s);
        });
        cmbPredavaci.setModel(ms);
    }

    private void ucitaj() {
        DefaultListModel<Grupa> m = new DefaultListModel<>();
        List<Grupa> entiteti = obrada.read();

        for (Grupa s : entiteti) {
            m.addElement(s);
        }
        // implementirati ćemo custom renderer https://www.codejava.net/java-se/swing/jlist-custom-renderer-example
        lstEntiteti.setModel(m);
    }

    private void ucitajPolaznike() {
        DefaultListModel<Polaznik> m = new DefaultListModel<>();
        List<Polaznik> entiteti;
        if (chbPocetakPrezimena.isSelected()) {
            entiteti = op.readPocetakPrezimena(txtUvjet.getText().trim());
        } else {
            entiteti = op.read(txtUvjet.getText().trim());
        }
        Collections.sort(entiteti, new PolaznikComparator());

        for (Polaznik s : entiteti) {
            m.addElement(s);
        }
        // implementirati ćemo custom renderer https://www.codejava.net/java-se/swing/jlist-custom-renderer-example
        lstPolazniciUSkoli.setModel(m);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstEntiteti = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        txtNaziv = new javax.swing.JTextField();
        btnKreiraj = new javax.swing.JButton();
        btnPromjeni = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        cmbSmjerovi = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cmbPredavaci = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        dpDatumPocetka = new com.github.lgooddatepicker.components.DatePicker();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstPolazniciUGrupi = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();
        txtUvjet = new javax.swing.JTextField();
        chbPocetakPrezimena = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        btnTrazi = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstPolazniciUSkoli = new javax.swing.JList<>();
        btnDodajPolaznike = new javax.swing.JButton();
        btnObrisiPolaznike = new javax.swing.JButton();
        btnExportJson = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lstEntiteti.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstEntitetiValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstEntiteti);

        jLabel1.setText("Ime");

        btnKreiraj.setText("Kreiraj");
        btnKreiraj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKreirajActionPerformed(evt);
            }
        });

        btnPromjeni.setText("Promjeni");
        btnPromjeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromjeniActionPerformed(evt);
            }
        });

        btnObrisi.setText("Obriši");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        jLabel2.setText("Smjer");

        jLabel3.setText("Predavač");

        jLabel4.setText("Datum početka");

        lstPolazniciUGrupi.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstPolazniciUGrupiValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(lstPolazniciUGrupi);

        jLabel5.setText("Polaznici u grupi");

        txtUvjet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUvjetKeyPressed(evt);
            }
        });

        chbPocetakPrezimena.setText("Po prezimenu");

        jLabel7.setText("Traži po imenu,prezimenu,Oib-u");

        btnTrazi.setText("Traži");
        btnTrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraziActionPerformed(evt);
            }
        });

        lstPolazniciUSkoli.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstPolazniciUSkoliValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(lstPolazniciUSkoli);

        btnDodajPolaznike.setText("<<");
        btnDodajPolaznike.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajPolaznikeActionPerformed(evt);
            }
        });

        btnObrisiPolaznike.setText(">>");
        btnObrisiPolaznike.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiPolaznikeActionPerformed(evt);
            }
        });

        btnExportJson.setText("Export JSON");
        btnExportJson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportJsonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbPredavaci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmbSmjerovi, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(dpDatumPocetka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addComponent(btnKreiraj)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPromjeni)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnObrisi)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnDodajPolaznike, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnObrisiPolaznike, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnExportJson))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtUvjet)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTrazi))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chbPocetakPrezimena))
                        .addGap(14, 14, 14)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel2)
                                        .addGap(4, 4, 4)
                                        .addComponent(cmbSmjerovi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3)
                                        .addGap(10, 10, 10)
                                        .addComponent(cmbPredavaci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel4)
                                        .addGap(12, 12, 12)
                                        .addComponent(dpDatumPocetka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(btnDodajPolaznike)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnObrisiPolaznike)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExportJson)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(285, 285, 285)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnKreiraj)
                    .addComponent(btnPromjeni)
                    .addComponent(btnObrisi))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTrazi)
                    .addComponent(txtUvjet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chbPocetakPrezimena)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lstEntitetiValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstEntitetiValueChanged
        if (evt.getValueIsAdjusting() || lstEntiteti.getSelectedValue() == null) {
            return;
        }
        obrada.setEntitet(lstEntiteti.getSelectedValue());
        var e = obrada.getEntitet();
        txtNaziv.setText(e.getNaziv());
        if (e.getSmjer() == null) {
            cmbSmjerovi.setSelectedIndex(0);
        } else {
            cmbSmjerovi.setSelectedItem(e.getSmjer());
        }
        if (e.getPredavac() == null) {
            cmbPredavaci.setSelectedIndex(0);
        } else {
            cmbPredavaci.setSelectedItem(e.getSmjer());
        }
        if (e.getDatumPocetka() != null) {
            dpDatumPocetka.setDate(e.getDatumPocetka().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        } else {
            dpDatumPocetka.setDate(null);
        }

        Collections.sort(e.getPolaznici(), new PolaznikComparator());
        DefaultListModel<Polaznik> m = new DefaultListModel();
        if (e.getPolaznici() != null) {
            Collections.sort(e.getPolaznici(), new PolaznikComparator());
            m.addAll(e.getPolaznici());
        }
        lstPolazniciUGrupi.setModel(m);
    }//GEN-LAST:event_lstEntitetiValueChanged

    private void btnKreirajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKreirajActionPerformed
        try {
            if (obrada.getEntitet() == null) {
                obrada.setEntitet(new Grupa());
            }
            preuzmiVrijednosti();
            obrada.create();
            ucitaj();
        } catch (EdunovaException ex) {
            JOptionPane.showMessageDialog(getRootPane(), ex.getPoruka());
        }
    }//GEN-LAST:event_btnKreirajActionPerformed

    private void btnPromjeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromjeniActionPerformed

        if (obrada.getEntitet() == null) {
            JOptionPane.showMessageDialog(getRootPane(), "Prvo odaberite stavku");
            return;
        }
        preuzmiVrijednosti();

        try {
            obrada.update();
            ucitaj();
        } catch (EdunovaException ex) {
            JOptionPane.showMessageDialog(getRootPane(), ex.getPoruka());
        }

    }//GEN-LAST:event_btnPromjeniActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed

        if (obrada.getEntitet() == null) {
            JOptionPane.showMessageDialog(getRootPane(), "Prvo odaberite stavku");
            return;
        }

        if (JOptionPane.showConfirmDialog(
                getRootPane(),
                "Sigurno obrisati \"" + obrada.getEntitet().getNaziv() + "\"?",
                "Brisanje",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE) == JOptionPane.NO_OPTION) {
            return;
        }

        try {
            obrada.delete();
            ucitaj();
        } catch (EdunovaException ex) {
            JOptionPane.showMessageDialog(getRootPane(), ex.getPoruka());
        }

    }//GEN-LAST:event_btnObrisiActionPerformed

    private void lstPolazniciUGrupiValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstPolazniciUGrupiValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_lstPolazniciUGrupiValueChanged

    private void txtUvjetKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUvjetKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            ucitajPolaznike();
        }
    }//GEN-LAST:event_txtUvjetKeyPressed

    private void btnTraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTraziActionPerformed
        ucitajPolaznike();
    }//GEN-LAST:event_btnTraziActionPerformed

    private void lstPolazniciUSkoliValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstPolazniciUSkoliValueChanged
        if (evt.getValueIsAdjusting() || lstPolazniciUSkoli.getSelectedValue() == null) {
            return;
        }
        op.setEntitet(lstPolazniciUSkoli.getSelectedValue());
        var e = op.getEntitet();

        if (e.getGrupe() != null && e.getGrupe().size() > 0) {
            btnObrisi.setEnabled(false);
        } else {
            btnObrisi.setEnabled(true);
        }

    }//GEN-LAST:event_lstPolazniciUSkoliValueChanged

    private void btnDodajPolaznikeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajPolaznikeActionPerformed
        DefaultListModel<Polaznik> m;
        if (obrada.getEntitet() != null) {
            m = (DefaultListModel<Polaznik>) lstPolazniciUGrupi.getModel();
        } else {
            obrada.setEntitet(new Grupa());
            obrada.getEntitet().setPolaznici(new ArrayList<>());
            preuzmiVrijednosti();
            m = new DefaultListModel<>();
            lstPolazniciUGrupi.setModel(m);
        }
        for (Polaznik p : lstPolazniciUSkoli.getSelectedValuesList()) {
            if (!postojiPolaznikUGrupi(m, p)) {
                obrada.getEntitet().getPolaznici().add(p);
                m.addElement(p);
            }

        }
        lstPolazniciUGrupi.repaint();
    }//GEN-LAST:event_btnDodajPolaznikeActionPerformed

    private void btnObrisiPolaznikeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiPolaznikeActionPerformed
        DefaultListModel<Polaznik> m = (DefaultListModel) lstPolazniciUGrupi.getModel();
        for (Polaznik p : lstPolazniciUGrupi.getSelectedValuesList()) {
            m.removeElement(p);
            for (Polaznik mp : obrada.getEntitet().getPolaznici()) {
                if (mp.getSifra().equals(p.getSifra())) {
                    obrada.getEntitet().getPolaznici().remove(mp);
                    break;
                }
            }
        }
        lstPolazniciUGrupi.repaint();

    }//GEN-LAST:event_btnObrisiPolaznikeActionPerformed

    private void btnExportJsonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportJsonActionPerformed
        ExclusionStrategy strategija = new ExclusionStrategy() {
            @Override
            public boolean shouldSkipField(FieldAttributes fa) {
                if (fa.getDeclaringClass() == Smjer.class && fa.getName().equals("grupe")) {
                    return true;
                }
                if (fa.getDeclaringClass() == Predavac.class && fa.getName().equals("grupe")) {
                    return true;
                }
                if(fa.getDeclaringClass() == Polaznik.class && fa.getName().equals("grupe")){
                    return true;
                }
                return false;
            }

            @Override
            public boolean shouldSkipClass(Class<?> type) {
                return false;
            }
        };
       
        
        
        
        Gson gson = new GsonBuilder().setExclusionStrategies(strategija).setPrettyPrinting().
                setDateFormat("yyyy-MM-d'T'HH:mm:ss.SSSZ").create();
        
        
        
        
        
        JFileChooser jfc = new JFileChooser();
        jfc.setCurrentDirectory(new File(System.getProperty("user.home")));
        jfc.setSelectedFile(new File(System.getProperty("user.home") + File.separator + "grupe.json"));
        if(jfc.showSaveDialog(this)==JFileChooser.APPROVE_OPTION){
            try {
                BufferedWriter writer   = new BufferedWriter(new FileWriter(jfc.getSelectedFile(),StandardCharsets.UTF_8));
                
                writer.write(gson.toJson(obrada.read()));
                writer.close();
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_btnExportJsonActionPerformed

    private boolean postojiPolaznikUGrupi(DefaultListModel<Polaznik> m, Polaznik p) {
        for (int i = 0; i < m.size(); i++) {
            if (m.get(i).getSifra().equals(p.getSifra())) {
                return true;
            }
        }
        return false;
    }

    private void preuzmiVrijednosti() {
        var e = obrada.getEntitet();
        e.setNaziv(txtNaziv.getText());
        e.setSmjer((Smjer) cmbSmjerovi.getSelectedItem());
        e.setPredavac((Predavac) cmbPredavaci.getSelectedItem());
        if (dpDatumPocetka.getDate() != null) {
            e.setDatumPocetka(Date.from(dpDatumPocetka.getDate().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        } else {
            e.setDatumPocetka(null);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodajPolaznike;
    private javax.swing.JButton btnExportJson;
    private javax.swing.JButton btnKreiraj;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnObrisiPolaznike;
    private javax.swing.JButton btnPromjeni;
    private javax.swing.JButton btnTrazi;
    private javax.swing.JCheckBox chbPocetakPrezimena;
    private javax.swing.JComboBox<Predavac> cmbPredavaci;
    private javax.swing.JComboBox<Smjer> cmbSmjerovi;
    private com.github.lgooddatepicker.components.DatePicker dpDatumPocetka;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<Grupa> lstEntiteti;
    private javax.swing.JList<Polaznik> lstPolazniciUGrupi;
    private javax.swing.JList<Polaznik> lstPolazniciUSkoli;
    private javax.swing.JTextField txtNaziv;
    private javax.swing.JTextField txtUvjet;
    // End of variables declaration//GEN-END:variables

}
