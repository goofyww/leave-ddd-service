package ddd.leave.domain.leave.entity;

import ddd.leave.domain.leave.entity.valueobject.Applicant;
import ddd.leave.domain.leave.entity.valueobject.Approver;
import ddd.leave.domain.leave.entity.valueobject.LeaveType;
import ddd.leave.domain.leave.entity.valueobject.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 请假单信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Leave {

    private String id;

    private Applicant applicant;

    private Approver approver;

    private LeaveType type;

    private Status status;

    private Date startTime;

    private Date endTime;

    private long duration;

    /**
     * 审批领导的最大级别
     */
    private int leaderMaxLevel;

    private ApprovalInfo currentApprovalInfo;

    private List<ApprovalInfo> historyApprovalInfos;

    public long getDuration() {
        return endTime.getTime() - startTime.getTime();
    }

    public Leave addHistoryApprovalInfo(ApprovalInfo approvalInfo) {
        if (null == historyApprovalInfos) {
            historyApprovalInfos = new ArrayList<>();
        }
        this.historyApprovalInfos.add(approvalInfo);
        return this;
    }

    public Leave create() {
        this.setStatus(Status.APPROVING);
        this.setStartTime(new Date());
        return this;
    }

    public Leave agree(Approver nextApprover) {
        this.setStatus(Status.APPROVING);
        this.setApprover(nextApprover);
        return this;
    }

    public Leave reject(Approver approver) {
        this.setApprover(approver);
        this.setStatus(Status.REJECTED);
        this.setApprover(null);
        return this;
    }

    public Leave finish() {
        this.setApprover(null);
        this.setStatus(Status.APPROVED);
        this.setEndTime(new Date());
        this.setDuration(this.getEndTime().getTime() - this.getStartTime().getTime());
        return this;
    }

}
