package com.comdosoft.union.bean.app;

import java.io.Serializable;
import java.util.Date;

/**
 * <br>
 * <The persistent class for the t_app_student database table.>
 *
 * @author zengguang 2014年12月5日
 *
 */
public class AppStudent implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;

    private String activationCode;

    private String token;

    private Date createTime;

    private String createUser;

    private String pushDeviceToken;

    private String pushChannelId;

    private String pushUserId;
    
    private String nationality;
    
    private String passportNumber;
    
    private String applyNumber;
    
    private int sexuality;
    
    private int maritalStatus;
    
    private Date  birthDate;
    
    private String birthCity;
    
    private String emergencyContactorAddress;
    
    private String emergencyContactorPhone;
    
    private int highestDegree;
    
    private String englishName;
    
    private int religion;
    
    private int languageChineseAbility;
    
    private int languageEnglishAbility;
    
    private Date  applyTime;
    
    private String economyGuarantor;
    
    private String economyGuarantorPhone;
    
    private String homeAddress;
    
    private String homePhone;
    
    /**
     * 设备类型3:Android、4:IOS
     */
    private int pushDeviceType;

    private String chineseName;

    private String studentEmail;

    private String studentMobilePhone;

    /**
     * 旧密码
     */
    private String studentOldPassword;

    private String studentPassword;

    /**
     * 用户状态（1待激活2正常3过期）
     */
    private int studentStatus = 1;

    private Date updateTime;

    private String updateUser;

    private int version;

    public AppStudent() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the activationCode
     */
    public String getActivationCode() {
        return activationCode;
    }

    /**
     * @param activationCode
     *            the activationCode to set
     */
    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    /**
     * @return the serialversionuid
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    /**
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token
     *            the token to set
     */
    public void setToken(String token) {
        this.token = token;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return this.createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    /**
     * @return the pushDeviceToken
     */
    public String getPushDeviceToken() {
        return pushDeviceToken;
    }

    /**
     * @param pushDeviceToken
     *            the pushDeviceToken to set
     */
    public void setPushDeviceToken(String pushDeviceToken) {
        this.pushDeviceToken = pushDeviceToken;
    }

    /**
     * @return the pushChannelId
     */
    public String getPushChannelId() {
        return pushChannelId;
    }

    /**
     * @param pushChannelId
     *            the pushChannelId to set
     */
    public void setPushChannelId(String pushChannelId) {
        this.pushChannelId = pushChannelId;
    }

    /**
     * @return the pushUserId
     */
    public String getPushUserId() {
        return pushUserId;
    }

    /**
     * @param pushUserId
     *            the pushUserId to set
     */
    public void setPushUserId(String pushUserId) {
        this.pushUserId = pushUserId;
    }

    /**
     * @return the pushDeviceType
     */
    public int getPushDeviceType() {
        return pushDeviceType;
    }

    /**
     * @param pushDeviceType
     *            the pushDeviceType to set
     */
    public void setPushDeviceType(int pushDeviceType) {
        this.pushDeviceType = pushDeviceType;
    }

    public String getStudentEmail() {
        return this.studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentMobilePhone() {
        return this.studentMobilePhone;
    }

    public void setStudentMobilePhone(String studentMobilePhone) {
        this.studentMobilePhone = studentMobilePhone;
    }

    /**
     * @return the studentOldPassword
     */
    public String getStudentOldPassword() {
        return studentOldPassword;
    }

    /**
     * @param studentOldPassword
     *            the studentOldPassword to set
     */
    public void setStudentOldPassword(String studentOldPassword) {
        this.studentOldPassword = studentOldPassword;
    }

    public String getStudentPassword() {
        return this.studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }

    /**
     * @return the studentStatus
     */
    public int getStudentStatus() {
        return studentStatus;
    }

    /**
     * @param studentStatus
     *            the studentStatus to set
     */
    public void setStudentStatus(int studentStatus) {
        this.studentStatus = studentStatus;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return this.updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public int getVersion() {
        return this.version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getChineseName() {
        return chineseName;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }


    public String getNationality() {
        return nationality;
    }


    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

 
    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

  
    public int getSexuality() {
        return sexuality;
    }


    public void setSexuality(int sexuality) {
        this.sexuality = sexuality;
    }


    public int getMaritalStatus() {
        return maritalStatus;
    }


    public void setMaritalStatus(int maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

 
    public Date getBirthDate() {
        return birthDate;
    }


    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

  
    public String getBirthCity() {
        return birthCity;
    }

  
    public void setBirthCity(String birthCity) {
        this.birthCity = birthCity;
    }


    public String getEmergencyContactorAddress() {
        return emergencyContactorAddress;
    }


    public void setEmergencyContactorAddress(String emergencyContactorAddress) {
        this.emergencyContactorAddress = emergencyContactorAddress;
    }


    public String getEmergencyContactorPhone() {
        return emergencyContactorPhone;
    }

 
    public void setEmergencyContactorPhone(String emergencyContactorPhone) {
        this.emergencyContactorPhone = emergencyContactorPhone;
    }

 
    public int getHighestDegree() {
        return highestDegree;
    }

    
    public void setHighestDegree(int highestDegree) {
        this.highestDegree = highestDegree;
    }


    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }


    public int getReligion() {
        return religion;
    }

    public void setReligion(int religion) {
        this.religion = religion;
    }

  
    public int getLanguageChineseAbility() {
        return languageChineseAbility;
    }


    public void setLanguageChineseAbility(int languageChineseAbility) {
        this.languageChineseAbility = languageChineseAbility;
    }


    public int getLanguageEnglishAbility() {
        return languageEnglishAbility;
    }

 
    public void setLanguageEnglishAbility(int languageEnglishAbility) {
        this.languageEnglishAbility = languageEnglishAbility;
    }

 
    public Date getApplyTime() {
        return applyTime;
    }

   
    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }


    public String getEconomyGuarantor() {
        return economyGuarantor;
    }


    public void setEconomyGuarantor(String economyGuarantor) {
        this.economyGuarantor = economyGuarantor;
    }


    public String getEconomyGuarantorPhone() {
        return economyGuarantorPhone;
    }


    public void setEconomyGuarantorPhone(String economyGuarantorPhone) {
        this.economyGuarantorPhone = economyGuarantorPhone;
    }

  
    public String getHomeAddress() {
        return homeAddress;
    }

  
    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }


    public String getHomePhone() {
        return homePhone;
    }


    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    
    public String getApplyNumber() {
        return applyNumber;
    }

  
    public void setApplyNumber(String applyNumber) {
        this.applyNumber = applyNumber;
    }
    

}