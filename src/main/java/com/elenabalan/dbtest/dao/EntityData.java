package com.elenabalan.dbtest.dao;

import javax.persistence.*;

@Entity
@Table(name="temptable")
public class EntityData {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="data")
    private byte[] data;
}
