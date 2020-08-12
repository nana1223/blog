package cn.zn.myblog.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Temporal 指定到数据库内对应的时间
 *           TemporalType：生成的时间类型
 *                         TIMESTAMP：日期+时间
 *                         DATE:只有日期
 *                         TIME：只有时间
 */
@Entity
@Table(name = "t_comment")
public class Comment {

    @Id
    @GeneratedValue
    private long id;

    private String nickname;
    private String email;
    private String content;
    private String avatar;//头像化身
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    @ManyToOne
    private Blog blog;

    //一条评论可被多个评论回复
    @OneToMany
    private List<Comment> replayComments = new ArrayList<>();

    //一个子类评论只能评论一个父类评论
    @ManyToOne
    private Comment parentComment;

    public Comment() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public List<Comment> getReplayComments() {
        return replayComments;
    }

    public void setReplayComments(List<Comment> replayComments) {
        this.replayComments = replayComments;
    }

    public Comment getParentComment() {
        return parentComment;
    }

    public void setParentComment(Comment parentComment) {
        this.parentComment = parentComment;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", content='" + content + '\'' +
                ", avatar='" + avatar + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
