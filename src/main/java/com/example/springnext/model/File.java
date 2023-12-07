package com.example.springnext.model;

import jakarta.persistence.*;

/**
 * Entitetsklass som representerar en fil i systemet.
 */
@Entity
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String contentType;
    private Long size;

    @Lob
    private byte[] data;

    @ManyToOne
    @JoinColumn(name = "folder_id")
    private Folder folder;

    // Standardkonstruktör
    public File() {
    }

    // Konstruktör med alla fält
    public File(String name, String contentType, Long size, byte[] data, Folder folder) {
        this.name = name;
        this.contentType = contentType;
        this.size = size;
        this.data = data;
        this.folder = folder;
    }

    // Hämtar filens ID
    public Long getId() {
        return id;
    }

    // Sätter filens ID
    public void setId(Long id) {
        this.id = id;
    }

    // Hämtar filens namn
    public String getName() {
        return name;
    }

    // Sätter filens namn
    public void setName(String name) {
        this.name = name;
    }

    // Hämtar filens innehållstyp
    public String getContentType() {
        return contentType;
    }

    // Sätter filens innehållstyp
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    // Hämtar filens storlek
    public Long getSize() {
        return size;
    }

    // Sätter filens storlek
    public void setSize(Long size) {
        this.size = size;
    }

    // Hämtar filens data
    public byte[] getData() {
        return data;
    }

    // Sätter filens data
    public void setData(byte[] data) {
        this.data = data;
    }

    // Hämtar den mapp som filen är associerad med
    public Folder getFolder() {
        return folder;
    }

    // Sätter den mapp som filen är associerad med
    public void setFolder(Folder folder) {
        this.folder = folder;
    }
}

