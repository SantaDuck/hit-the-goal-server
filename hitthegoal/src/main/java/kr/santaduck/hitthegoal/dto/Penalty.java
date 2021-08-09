package kr.santaduck.hitthegoal.dto;

import java.util.Date;

public class Penalty {
	private Integer id;
	private Integer teamId;
	private Integer term;
	private Integer memberId;
	private String contents;
	private Boolean isAchived;
	private Date createDate;
	private Integer approvals;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTeamId() {
		return teamId;
	}
	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}
	public Integer getTerm() {
		return term;
	}
	public void setTerm(Integer term) {
		this.term = term;
	}
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Boolean getIsAchived() {
		return isAchived;
	}
	public void setIsAchived(Boolean isAchived) {
		this.isAchived = isAchived;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Integer getApprovals() {
		return approvals;
	}
	public void setApprovals(Integer approvals) {
		this.approvals = approvals;
	}
	
	
}
