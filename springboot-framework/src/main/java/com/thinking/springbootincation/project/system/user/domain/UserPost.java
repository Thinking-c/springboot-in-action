package com.thinking.springbootincation.project.system.user.domain;

 /**
 *
 * @Author：caoj
 * @Description： 用户岗位关联 sys_user_post
 * @Date：Created in 2018/7/26
 */
public class UserPost {
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 岗位ID
     */
    private Long postId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    @Override
    public String toString() {
        return "UserPost [userId=" + userId + ", postId=" + postId + "]";
    }

}
