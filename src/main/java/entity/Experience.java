package entity;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "experiences")
public class Experience implements Serializable{
	@Id
	@Column(name = "company_name")
	private String companyname;
	@Column(name = "from_date")
	private LocalDate fromDate;
	@Column(name ="to_date")
	private	LocalDate toDate;
	private String description;
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name= "candidate_id", referencedColumnName = "candidate_id")
	private Candidate candidate;
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "position_id", referencedColumnName = "position_id")
	private Position position;
	
	
	public Experience(String companyname, LocalDate fromDate, LocalDate toDate, String description, Candidate candidate,
			Position position) {
		super();
		this.companyname = companyname;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.description = description;
		this.candidate = candidate;
		this.position = position;
	}
	public Experience() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public LocalDate getFromDate() {
		return fromDate;
	}
	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}
	public LocalDate getToDate() {
		return toDate;
	}
	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDesription(String description) {
		this.description = description;
	}
	public Candidate getCandidate() {
		return candidate;
	}
	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	@Override
	public String toString() {
		return "Experience [companyname=" + companyname + ", fromDate=" + fromDate + ", toDate=" + toDate
				+ ", description=" + description + ", candidate=" + candidate + ", position=" + position + "]";
	}
	
	
	
}
