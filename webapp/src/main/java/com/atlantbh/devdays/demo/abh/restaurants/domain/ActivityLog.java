package com.atlantbh.devdays.demo.abh.restaurants.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "activitylogs")
public class ActivityLog {
        @Id
        @GeneratedValue
        @Column(name = "id")
        private Long id;

        @Column(name = "user")
        private String user;

        @Column(name = "action")
        private String action;

        @Column(name = "created_at", updatable = false, insertable = false)
        private Date createdAt;

}
