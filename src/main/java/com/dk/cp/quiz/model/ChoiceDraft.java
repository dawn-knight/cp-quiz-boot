package com.dk.cp.quiz.model;

import java.util.Date;

public class ChoiceDraft {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column quiz_choice_draft.id
     *
     * @mbg.generated Sat Dec 17 23:30:42 CST 2016
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column quiz_choice_draft.drafter_id
     *
     * @mbg.generated Sat Dec 17 23:30:42 CST 2016
     */
    private Integer drafterId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column quiz_choice_draft.created_time
     *
     * @mbg.generated Sat Dec 17 23:30:42 CST 2016
     */
    private Date createdTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column quiz_choice_draft.status
     *
     * @mbg.generated Sat Dec 17 23:30:42 CST 2016
     */
    private Boolean status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column quiz_choice_draft.level
     *
     * @mbg.generated Sat Dec 17 23:30:42 CST 2016
     */
    private Byte level;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column quiz_choice_draft.image_id
     *
     * @mbg.generated Sat Dec 17 23:30:42 CST 2016
     */
    private Integer imageId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column quiz_choice_draft.question
     *
     * @mbg.generated Sat Dec 17 23:30:42 CST 2016
     */
    private String question;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column quiz_choice_draft.id
     *
     * @return the value of quiz_choice_draft.id
     *
     * @mbg.generated Sat Dec 17 23:30:42 CST 2016
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column quiz_choice_draft.id
     *
     * @param id the value for quiz_choice_draft.id
     *
     * @mbg.generated Sat Dec 17 23:30:42 CST 2016
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column quiz_choice_draft.drafter_id
     *
     * @return the value of quiz_choice_draft.drafter_id
     *
     * @mbg.generated Sat Dec 17 23:30:42 CST 2016
     */
    public Integer getDrafterId() {
        return drafterId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column quiz_choice_draft.drafter_id
     *
     * @param drafterId the value for quiz_choice_draft.drafter_id
     *
     * @mbg.generated Sat Dec 17 23:30:42 CST 2016
     */
    public void setDrafterId(Integer drafterId) {
        this.drafterId = drafterId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column quiz_choice_draft.created_time
     *
     * @return the value of quiz_choice_draft.created_time
     *
     * @mbg.generated Sat Dec 17 23:30:42 CST 2016
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column quiz_choice_draft.created_time
     *
     * @param createdTime the value for quiz_choice_draft.created_time
     *
     * @mbg.generated Sat Dec 17 23:30:42 CST 2016
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column quiz_choice_draft.status
     *
     * @return the value of quiz_choice_draft.status
     *
     * @mbg.generated Sat Dec 17 23:30:42 CST 2016
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column quiz_choice_draft.status
     *
     * @param status the value for quiz_choice_draft.status
     *
     * @mbg.generated Sat Dec 17 23:30:42 CST 2016
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column quiz_choice_draft.level
     *
     * @return the value of quiz_choice_draft.level
     *
     * @mbg.generated Sat Dec 17 23:30:42 CST 2016
     */
    public Byte getLevel() {
        return level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column quiz_choice_draft.level
     *
     * @param level the value for quiz_choice_draft.level
     *
     * @mbg.generated Sat Dec 17 23:30:42 CST 2016
     */
    public void setLevel(Byte level) {
        this.level = level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column quiz_choice_draft.image_id
     *
     * @return the value of quiz_choice_draft.image_id
     *
     * @mbg.generated Sat Dec 17 23:30:42 CST 2016
     */
    public Integer getImageId() {
        return imageId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column quiz_choice_draft.image_id
     *
     * @param imageId the value for quiz_choice_draft.image_id
     *
     * @mbg.generated Sat Dec 17 23:30:42 CST 2016
     */
    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column quiz_choice_draft.question
     *
     * @return the value of quiz_choice_draft.question
     *
     * @mbg.generated Sat Dec 17 23:30:42 CST 2016
     */
    public String getQuestion() {
        return question;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column quiz_choice_draft.question
     *
     * @param question the value for quiz_choice_draft.question
     *
     * @mbg.generated Sat Dec 17 23:30:42 CST 2016
     */
    public void setQuestion(String question) {
        this.question = question == null ? null : question.trim();
    }
}