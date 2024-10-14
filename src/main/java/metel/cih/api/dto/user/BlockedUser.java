package metel.cih.api.dto.user;

import lombok.Data;

@Data
public class BlockedUser {
    private String uid;
    private String blockedDt;
    private String reason;
    private String unblock;
    private String unblockReason;
    private String unblockDt;
}
