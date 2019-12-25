package model;

import javax.persistence.*;
import java.util.Objects;

/*
 *   #auther:李琪
 *   #date: 2019/12/20
 *   #description
 */
@Entity
@Table(name = "tb_pinglun", schema = "db_tb", catalog = "")
public class TbPinglun {
    private int id;

    private TbShangpin shangpin;
    private String title;
    private String content;
    private String time;

    private User user;

    public TbShangpin getShangpin() {
        return shangpin;
    }

    public void setShangpin(TbShangpin shangpin) {
        this.shangpin = shangpin;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "time")
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TbPinglun tbPinglun = (TbPinglun) o;
        return id == tbPinglun.id &&


                Objects.equals(title, tbPinglun.title) &&
                Objects.equals(content, tbPinglun.content) &&
                Objects.equals(time, tbPinglun.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content, time);
    }
}
