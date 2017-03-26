package com.PamFields;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by Pam on 3/26/2017.
 */
public class AgileorWaterfallGUI extends JFrame{
    private JCheckBox numberOfProgrammersCheckBox;
    private JCheckBox fixedScheduleCheckBox;
    private JCheckBox looseQCRequirementsCheckBox;
    private JCheckBox newProgrammersCheckBox;
    private JCheckBox earlyIntegrationCheckBox;
    private JCheckBox finalProjectOnlyCheckBox;
    private JButton quitProgramButton;
    private JPanel rootPanel;
    private JLabel surveyResultsLabel;
    private JLabel RecommendationLabel;

    private boolean numberOfProgrammers;
    private boolean fixedSchedule;
    private boolean looseQCRequirements;
    private boolean newProgrammers;
    private boolean earlyIntegration;
    private boolean finalProjectOnly;
    private int waterfall=0;
    private boolean agile = false;

    AgileorWaterfallGUI(){
        setContentPane(rootPanel);
        pack();
        setVisible(true);
        setSize(new Dimension(400, 300));
        setTitle("Agile or Waterfall Project Recommendation");

        numberOfProgrammersCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                numberOfProgrammers = numberOfProgrammersCheckBox.isSelected();
                updateResults();
                waterfall++;
                recommendation(waterfall,agile);
            }
        });
        fixedScheduleCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                fixedSchedule = fixedScheduleCheckBox.isSelected();
                updateResults();
                waterfall++;
                recommendation(waterfall,agile);
            }
        });
        looseQCRequirementsCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                looseQCRequirements = looseQCRequirementsCheckBox.isSelected();
                updateResults();
                waterfall++;
                recommendation(waterfall,agile);
            }
        });
        newProgrammersCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                newProgrammers = newProgrammersCheckBox.isSelected();
                updateResults();
                recommendation(waterfall,agile);
            }
        });
        earlyIntegrationCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                earlyIntegration = earlyIntegrationCheckBox.isSelected();
                updateResults();
                waterfall++;
                recommendation(waterfall,agile);
            }
        });
        finalProjectOnlyCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                finalProjectOnly = finalProjectOnlyCheckBox.isSelected();
                updateResults();
                waterfall++;
                recommendation(waterfall,agile);
            }
        });
        quitProgramButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int quit = JOptionPane.showConfirmDialog(AgileorWaterfallGUI.this, "Are you sure you want to quit?",
                        "Confirm quit",
                        JOptionPane.OK_CANCEL_OPTION);
            }
        });
    }
    private void updateResults() {
        String hasnumberOfProgrammers = numberOfProgrammers ? "has 10 or more programmers": "less than 10 programmers";
        String hasfixedSchedule = fixedSchedule ? "has a fixed schedule": "has loose schedule";
        String haslooseQCRequirements = looseQCRequirements ? "has loose quality control requirements": "has strict quality control requirements";
        String hasnewProgrammers = newProgrammers ? "has new programmers to the project": "has veteran programmers to the project";
        String hasearlyIntegration = earlyIntegration ? "has to integrate early": "has no need for early integration";
        String hasfinalProjectOnly = finalProjectOnly ? "has to except final project": "has to have early iterations";

        String results = "Your Project "+hasnumberOfProgrammers+" and "+hasfixedSchedule+" and "+haslooseQCRequirements+" and "+hasnewProgrammers+" and "+hasearlyIntegration+" and "+hasfinalProjectOnly;
        surveyResultsLabel.setText(results);
    }

    private void recommendation(int waterfall, boolean agile){
        String output;//if true, use waterfall, if false, use Agile
        if (waterfall <=3){
            agile = false;
        } else{
            agile = true;
        }
        if(agile){
            output =("You should seriously consider using the Agile method for your project.");
        } else{
            output =("You should seriously consider using the waterfall method for your project.");
        }
        RecommendationLabel.setText(output);
    }
    }


