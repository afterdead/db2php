/*
 * Copyright (C) 2008 Andreas Schnaiter
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301  USA
 */
package org.afraid.poison.db2php;

import java.io.File;
import java.net.URISyntaxException;
import java.util.Vector;
import java.util.prefs.Preferences;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import org.afraid.poison.db2php.generator.databaselayer.DatabaseLayer;
import org.netbeans.api.project.Project;
import org.netbeans.spi.project.ui.templates.support.Templates;
import org.openide.WizardDescriptor;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileStateInvalidException;
import org.openide.util.Exceptions;
import org.openide.util.NbPreferences;

public final class PhpClassVisualPanel2 extends JPanel {

	private WizardDescriptor wizard;
	private File defaultDirectory;
	private File directory;

	/** Creates new form PhpClassVisualPanel2 */
	public PhpClassVisualPanel2(WizardDescriptor wizard) {
		setWizard(wizard);

		initComponents();
		readSettings();
	}

	@Override
	public String getName() {
		return "Options";
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        databaseLayerSelection = new javax.swing.JComboBox();
        generateChecksSelection = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        destinationDirectory = new javax.swing.JTextField();
        buttonBrowse = new javax.swing.JButton();
        trackModificationsSelection = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        classNamePrefix = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        classNameSuffix = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        identifierQuoteString = new javax.swing.JComboBox();
        fluentInterfaceSelection = new javax.swing.JCheckBox();

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(PhpClassVisualPanel2.class, "PhpClassVisualPanel2.jLabel1.text_2")); // NOI18N

        databaseLayerSelection.setModel(getAvailableDatabaseLayers());

        org.openide.awt.Mnemonics.setLocalizedText(generateChecksSelection, org.openide.util.NbBundle.getMessage(PhpClassVisualPanel2.class, "PhpClassVisualPanel2.generateChecksSelection.text")); // NOI18N
        generateChecksSelection.setEnabled(false);

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(PhpClassVisualPanel2.class, "PhpClassVisualPanel2.jLabel2.text_2")); // NOI18N

        destinationDirectory.setEditable(false);
        destinationDirectory.setText(getDirectory().getAbsolutePath());
        destinationDirectory.setToolTipText(org.openide.util.NbBundle.getMessage(PhpClassVisualPanel2.class, "PhpClassVisualPanel2.destinationDirectory.toolTipText")); // NOI18N
        destinationDirectory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                destinationDirectoryActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(buttonBrowse, org.openide.util.NbBundle.getMessage(PhpClassVisualPanel2.class, "PhpClassVisualPanel2.buttonBrowse.text")); // NOI18N
        buttonBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBrowseActionPerformed(evt);
            }
        });

        trackModificationsSelection.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(trackModificationsSelection, org.openide.util.NbBundle.getMessage(PhpClassVisualPanel2.class, "PhpClassVisualPanel2.trackModificationsSelection.text")); // NOI18N
        trackModificationsSelection.setToolTipText(org.openide.util.NbBundle.getMessage(PhpClassVisualPanel2.class, "PhpClassVisualPanel2.trackModificationsSelection.toolTipText")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(PhpClassVisualPanel2.class, "PhpClassVisualPanel2.jLabel3.text")); // NOI18N

        classNamePrefix.setText(org.openide.util.NbBundle.getMessage(PhpClassVisualPanel2.class, "PhpClassVisualPanel2.classNamePrefix.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(PhpClassVisualPanel2.class, "PhpClassVisualPanel2.jLabel4.text")); // NOI18N

        classNameSuffix.setText(org.openide.util.NbBundle.getMessage(PhpClassVisualPanel2.class, "PhpClassVisualPanel2.classNameSuffix.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel5, org.openide.util.NbBundle.getMessage(PhpClassVisualPanel2.class, "PhpClassVisualPanel2.jLabel5.text")); // NOI18N

        identifierQuoteString.setModel(new javax.swing.DefaultComboBoxModel(DatabaseLayer.DEFAULT_QUOTE_STRINGS));
        identifierQuoteString.setToolTipText(org.openide.util.NbBundle.getMessage(PhpClassVisualPanel2.class, "PhpClassVisualPanel2.identifierQuoteString.toolTipText")); // NOI18N

        fluentInterfaceSelection.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(fluentInterfaceSelection, org.openide.util.NbBundle.getMessage(PhpClassVisualPanel2.class, "PhpClassVisualPanel2.fluentInterfaceSelection.text")); // NOI18N
        fluentInterfaceSelection.setToolTipText(org.openide.util.NbBundle.getMessage(PhpClassVisualPanel2.class, "PhpClassVisualPanel2.fluentInterfaceSelection.toolTipText")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(identifierQuoteString, 0, 118, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(classNameSuffix, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(classNamePrefix, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(databaseLayerSelection, 0, 144, Short.MAX_VALUE)))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fluentInterfaceSelection)
                            .addComponent(generateChecksSelection)
                            .addComponent(trackModificationsSelection)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(destinationDirectory, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonBrowse)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(databaseLayerSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(generateChecksSelection))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(classNamePrefix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(trackModificationsSelection))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(classNameSuffix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fluentInterfaceSelection))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(identifierQuoteString, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(destinationDirectory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonBrowse))
                .addContainerGap(139, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

	private void buttonBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBrowseActionPerformed
		JFileChooser fChooser=new JFileChooser(getDirectory());
		fChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fChooser.setMultiSelectionEnabled(false);
		if (JFileChooser.APPROVE_OPTION==fChooser.showOpenDialog(buttonBrowse)) {
			setDirectory(fChooser.getSelectedFile());
		}
	}//GEN-LAST:event_buttonBrowseActionPerformed

	private void destinationDirectoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_destinationDirectoryActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_destinationDirectoryActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBrowse;
    private javax.swing.JTextField classNamePrefix;
    private javax.swing.JTextField classNameSuffix;
    private javax.swing.JComboBox databaseLayerSelection;
    private javax.swing.JTextField destinationDirectory;
    private javax.swing.JCheckBox fluentInterfaceSelection;
    private javax.swing.JCheckBox generateChecksSelection;
    private javax.swing.JComboBox identifierQuoteString;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JCheckBox trackModificationsSelection;
    // End of variables declaration//GEN-END:variables

	/**
	 * @return the wizard
	 */
	public WizardDescriptor getWizard() {
		return wizard;
	}

	/**
	 * @param wizard the wizard to set
	 */
	public void setWizard(WizardDescriptor wizard) {
		this.wizard=wizard;
	}

	/**
	 * @return the defaultDirectory
	 */
	public synchronized File getDefaultDirectory() {
		if (null==defaultDirectory) {
			FileObject targetFolder=Templates.getTargetFolder(getWizard());
			if (null!=targetFolder) {
				try {
					defaultDirectory=new File(targetFolder.getURL().toURI());
				} catch (FileStateInvalidException ex) {
					Exceptions.printStackTrace(ex);
				} catch (URISyntaxException ex) {
					Exceptions.printStackTrace(ex);
				}
			}
			if (null==defaultDirectory) {
				Project project=Templates.getProject(getWizard());
				if (null!=project) {
					FileObject projectDirectory=project.getProjectDirectory();
					if (null!=projectDirectory) {
						try {
							defaultDirectory=new File(projectDirectory.getURL().toURI());
						} catch (FileStateInvalidException ex) {
							Exceptions.printStackTrace(ex);
						} catch (URISyntaxException ex) {
							Exceptions.printStackTrace(ex);
						}
					}
				}
			}
			if (null==defaultDirectory) {
				defaultDirectory=new File(System.getProperty("user.home"));
			}
		}
		return defaultDirectory;
	}

	/**
	 * @param defaultDirectory the defaultDirectory to set
	 */
	public void setDefaultDirectory(File defaultDirectory) {
		this.defaultDirectory=defaultDirectory;
	}

	/**
	 * @return the directory
	 */
	public synchronized File getDirectory() {
		if (null==directory) {
			return getDefaultDirectory();
		}
		return directory;
	}

	/**
	 * @param directory the directory to set
	 */
	public synchronized void setDirectory(File directory) {
		this.directory=directory;
		getDestinationDirectory().setText(directory.getAbsolutePath());
	}

	/**
	 * @return the buttonBrowse
	 */
	public javax.swing.JButton getButtonBrowse() {
		return buttonBrowse;
	}

	/**
	 * @return the destinationDirectory
	 */
	public javax.swing.JTextField getDestinationDirectory() {
		return destinationDirectory;
	}

	/**
	 * @param destinationDirectory the destinationDirectory to set
	 */
	public void setDestinationDirectory(javax.swing.JTextField destinationDirectory) {
		this.destinationDirectory=destinationDirectory;
	}

	public ComboBoxModel getAvailableDatabaseLayers() {
		ComboBoxModel dbLayerModel=new DefaultComboBoxModel(new Vector<Object>(DatabaseLayer.AVAILABLE));
		dbLayerModel.setSelectedItem(DatabaseLayer.PDO);
		return dbLayerModel;
	}

	/**
	 * @return the classNamePrefix
	 */
	public javax.swing.JTextField getClassNamePrefix() {
		return classNamePrefix;
	}

	/**
	 * @return the classNameSuffix
	 */
	public javax.swing.JTextField getClassNameSuffix() {
		return classNameSuffix;
	}

	/**
	 * @return the databaseLayerSelection
	 */
	public javax.swing.JComboBox getDatabaseLayerSelection() {
		return databaseLayerSelection;
	}

	/**
	 * @return the trackModificationsSelection
	 */
	public javax.swing.JCheckBox getTrackModificationsSelection() {
		return trackModificationsSelection;
	}

	/**
	 * @return the generateChecksSelection
	 */
	public javax.swing.JCheckBox getGenerateChecksSelection() {
		return generateChecksSelection;
	}

	/**
	 * @return the identifierQuoteString
	 */
	public javax.swing.JComboBox getIdentifierQuoteString() {
		return identifierQuoteString;
	}

	/**
	 * @return the fluentInterfaceSelection
	 */
	public javax.swing.JCheckBox getFluentInterfaceSelection() {
		return fluentInterfaceSelection;
	}

	public void readSettings() {
		Preferences pref=NbPreferences.forModule(getClass());
		String setting=pref.get("DatabaseLayer", null);
		if (null!=setting) {
			for (DatabaseLayer databaseLayer : DatabaseLayer.AVAILABLE) {
				if (databaseLayer.getDbTypeName().equals(setting)) {
					getDatabaseLayerSelection().setSelectedItem(databaseLayer);
					break;
				}
			}
		}
		getClassNamePrefix().setText(pref.get("ClassNamePrefix", ""));
		getClassNameSuffix().setText(pref.get("ClassNameSuffix", "Model"));
		setting=pref.get("IdentifierQuoteString", DatabaseLayer.DEFAULT_QUOTE_STRINGS[1]);
		getIdentifierQuoteString().setSelectedItem(setting);
		getGenerateChecksSelection().setSelected(pref.getBoolean("TypeChecks", false));
		getTrackModificationsSelection().setSelected(pref.getBoolean("TrackModifications", true));
		getFluentInterfaceSelection().setSelected(pref.getBoolean("FluentInterface", true));

	}

	public void storeSettings() {
		Preferences pref=NbPreferences.forModule(getClass());
		pref.put("DatabaseLayer", ((DatabaseLayer) getDatabaseLayerSelection().getSelectedItem()).getDbTypeName());
		pref.put("ClassNamePrefix", getClassNamePrefix().getText());
		pref.put("ClassNameSuffix", getClassNameSuffix().getText());
		pref.put("IdentifierQuoteString", getIdentifierQuoteString().getSelectedItem().toString());
		pref.putBoolean("TypeChecks", getGenerateChecksSelection().isSelected());
		pref.putBoolean("TrackModifications", getTrackModificationsSelection().isSelected());
		pref.putBoolean("FluentInterface", getFluentInterfaceSelection().isSelected());

	}

	/*
	@Override
	public boolean isValid() {
	return true; //null!=getDirectory() && getDirectory().isDirectory() && getDirectory().canWrite();
	}
	 */
}

