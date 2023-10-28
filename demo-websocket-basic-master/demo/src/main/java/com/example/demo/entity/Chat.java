package com.example.demo.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maChat;
    @Column(columnDefinition = "TEXT")
    private String cauHoi;

    @Column(columnDefinition = "TEXT")
    private String traLoi;

    @CreationTimestamp
    private LocalDateTime ngayTao;

    @UpdateTimestamp
    private LocalDateTime ngayCapNhat;

    public Chat() {

    }

    public Long getMaChat() {
        return maChat;
    }

    public void setMaChat(Long maCauHoi) {
        this.maChat = maCauHoi;
    }

    public String getCauHoi() {
        return cauHoi;
    }

    public void setCauHoi(String cauHoi) {
        this.cauHoi = cauHoi;
    }

    public String getTraLoi() {
        return traLoi;
    }

    public void setTraLoi(String traLoi) {
        this.traLoi = traLoi;
    }

    public LocalDateTime getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(LocalDateTime ngayTao) {
        this.ngayTao = ngayTao;
    }

    public LocalDateTime getNgayCapNhat() {
        return ngayCapNhat;
    }

    public void setNgayCapNhat(LocalDateTime ngayCapNhat) {
        this.ngayCapNhat = ngayCapNhat;
    }

    public Chat(Long maChat, String cauHoi, String traLoi, LocalDateTime ngayTao, LocalDateTime ngayCapNhat) {
        this.maChat = maChat;
        this.cauHoi = cauHoi;
        this.traLoi = traLoi;
        this.ngayTao = ngayTao;
        this.ngayCapNhat = ngayCapNhat;
    }
}
