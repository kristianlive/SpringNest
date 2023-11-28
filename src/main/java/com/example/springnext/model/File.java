package com.example.springnext.model;

import jakarta.persistence.*;

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

        public File() {
        }

        public File(String name, String contentType, Long size, byte[] data, Folder folder) {
            this.name = name;
            this.contentType = contentType;
            this.size = size;
            this.data = data;
            this.folder = folder;
        }

        // standard getters and setters
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getContentType() {
            return contentType;
        }

        public void setContentType(String contentType) {
            this.contentType = contentType;
        }

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        public byte[] getData() {
            return data;
        }

        public void setData(byte[] data) {
            this.data = data;
        }

        public Folder getFolder() {
            return folder;
        }

        public void setFolder(Folder folder) {
            this.folder = folder;
        }
    }

