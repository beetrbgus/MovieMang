package com.moviemang.coreutils.common.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
	COMMON_SYSTEM_ERROR("�Ͻ����� ������ �߻��߽��ϴ�. ��� �� �ٽ� �õ����ּ���."), // ��� ��Ȳ
    COMMON_INVALID_PARAMETER("��û�� ���� �ùٸ��� �ʽ��ϴ�."),
    COMMON_ENTITY_NOT_FOUND("�������� �ʴ� ��ƼƼ�Դϴ�."),
    COMMON_ILLEGAL_STATUS("�߸��� ���°��Դϴ�.");

    private final String errorMsg;

    // Object... arg <= Object���� �Ű������� ��� ���� �� �ִ�.
    public String getErrorMsg(Object... arg) {
        return String.format(errorMsg, arg);
    }
	
}
