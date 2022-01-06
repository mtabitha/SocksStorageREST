package ru.salikhov.entity;

import javax.persistence.*;

@Entity
public class RegistrationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "socks_id", referencedColumnName = "id")
    private SocksEntity socks;

    @Column(name = "operation")
    private String operation;

    public RegistrationEntity() {
    }

    public RegistrationEntity(String operation, int quantity) {
        this.operation = operation;
        this.quantity = quantity;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    private int quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SocksEntity getSocks() {
        return socks;
    }

    public void setSocks(SocksEntity socks) {
        this.socks = socks;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
