package com.springcach.model;

import jakarta.persistence.*;


@Entity
public class Category  extends BaseEntity {

    private String flag;

    @Override
    public String toString() {
        return "Category{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", logoPath='" + getLogoPath() + '\'' +
                "flag='" + flag + '\'' +
                '}';
    }
}
