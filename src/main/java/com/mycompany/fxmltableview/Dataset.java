/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fxmltableview;

import java.io.File;
import java.util.List;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;

/**
 *
 * @author stefankoch
 * Store information about a Dataset
 * 
 * 
 */
public class Dataset {
    
    //holds files
    private ObservableList<RawDataFile> listofFiles;
    
    //name of Dataset
    private StringProperty name;
    
    //Default values for new Files
    private Property<Color> color;
    private DoubleProperty Width;

    
    
    //Constructor
    public Dataset() {
        
        this.listofFiles = FXCollections.observableArrayList();
        //default values for new Dataset
        this.Width = new SimpleDoubleProperty(2.0);
        this.color = new SimpleObjectProperty(Color.BLACK);
        
    }
    
    
    //add new File and parse it
    public void addFile(File file, ObservableList<Entry> data, float RTTolerance, float MZTolerance) {
        RawDataFile newfile = new RawDataFile(file, this.color, this.Width);
        this.listofFiles.add(newfile); 
        newfile.parseFile();
        System.out.println("parsed");
        newfile.extractSlices(data, RTTolerance, MZTolerance);
        
        
    }
    
    /**
     * @return the listofFiles
     */
    public ObservableList<RawDataFile> getListofFiles() {
        return listofFiles;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name.get();
    }
    
    public StringProperty getNameProperty() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = new SimpleStringProperty(name);
    }
    
    public final Color getColor() {
	return color.getValue();
    }

    public final void setColor(Color color) {
	this.color.setValue(color);
    }
    
    public Property<Color> getColorProperty() {
	return color;
    }

    /**
     * @return the width
     */
    public double getWidth() {
        return Width.get();
    }

    /**
     * @param width the width to set
     */
    public void setWidth(DoubleProperty width) {
        this.Width = width;
    }
    
    public DoubleProperty getWidthProperty() {
        return Width;
    }
}
