package com.example.filmlibrary.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@SequenceGenerator(
        name = "default_generator",
        sequenceName = "order_seq",
        allocationSize = 1)
public class Order extends GenericModel {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "FK_ORDER_USER"))
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "film_id", foreignKey = @ForeignKey(name = "FK_ORDER_FILM"))
    private Film film;

    @Column(name = "rent_date", nullable = false)
    private LocalDateTime rentDate;

    /**
     * Количество дней аренды
     */
    @Column(name = "rent_period", nullable = false)
    private Integer rentPeriod;

    @Column(name = "purchase")
    private Boolean isPurchased;
}
