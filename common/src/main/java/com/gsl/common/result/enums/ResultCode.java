package com.gsl.common.result.enums;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public enum ResultCode implements IBundleEnum{
    /**
     * 返回码对应的值
     */
    SUCCESS("000000"),
    BIZ_EXCEPTION("000001"),
    NO_BIZ_EXCEPTION("000002"),
    FAILED("000003"),
    GROUP_FAILED("000004"),
    PUBLISH_SUCCESS("000005"),
    DELETE_SUCCESS("000006"),
    UPDATE_TODO_STATUS_SUCCESS("000007"),
    SAVE_TODO_SUCCESS("000008"),
    MODIFY_SUCCESS("000009"),
    SAVE_SUCCESS("000010"),
    GROUP_SUCCESS("000011"),
    UPLOAD_SUCCESS("000012"),
    NO_ACCESS_PERMISSION("000013"),
    NO_LOGIN_ACCESS("000014"),
    NO_LOGIN_IP_ACCESS("000016"),
    NO_LOGIN_ERROR("000015"),
    UNKNOWN_ERROR("000500"),
    CONNECT_ERROR("100001"),
    CONNECT_TIMEOUT("100002"),
    INTERNAL_SERVER_ERROR("100003"),
    NO_SUPPORT_REQUEST_ERROR("100004"),
    GATEWAY_ERROR("100005"),
    UNABLE_HANDLER_REQUEST_ERROR("100006"),
    SERVER_BUSY_ERROR("100007"),
    REFER_INFO_ERROR("100008"),
    REQ_OVERTIME_ERROR("100009"),
    TOKEN_VALIDATE_ERROR("100010"),
    TOKEN_VALIDATE_FAILED("100011"),
    GRANT_TYPE_ERROR("100012"),
    LACK_OF_PARAM_ERROR("100013"),
    USER_NOT_EXIST_ERROR("100014"),
    USER_NOT_ENABLE_ERROR("100015"),
    USER_NAME_USED_ERROR("100016"),
    PHONE_NUMBER_USED_ERROR("100017"),
    EMAIL_USED_ERROR("100018"),
    USER_NAME_MODIFIED_ERROR("100019"),
    STATUS_VALUE_ERROR("100020"),
    ID_ERROR("100021"),
    START_STATUS_MODIFY_ERROR("100022"),
    PHONE_NUMBER_NOT_EXIST("100023"),
    EMAIL_NOT_EXIST("100024"),
    VERIFICATION_CODE_ERROR("100025"),
    VERIFICATION_ERROR("100026"),
    OLD_PASSWORD_ERROR("100027"),
    EMAIL_TEMPLATE_NOT_EXIST("100028"),
    SEND_EMAIL_VERIFICATION_CODE_ERROR("100029"),
    SEND_PHONE_VERIFICATION_CODE_ERROR("100030"),
    DYNAMIC_MESSAGE_NOT_EXIST("100031"),
    SKIP_ERROR("100032"),
    UPLOAD_PATH_ERROR("100033"),
    CR_USER_NOT_FOUND_ERROR("100034"),
    VALIDATE_ERROR("200000"),
    NO_ACCESS_ERROR("200001"),
    IDENTITY_AUTH_ERROR("200002"),
    NOT_EXISTS_USER_ERROR("200003"),
    NOT_EXISTS_ROLE_ERROR("200004"),
    PARAMETER_ERROR("200005"),
    COLUMN_NOT_NULL_ERROR("200006"),
    DATE_FORMAT_ERROR("200007"),
    NUMBER_FORMAT_ERROR("200008"),
    AMOUNT_FORMAT_ERROR("200009"),
    LENGTH_ERROR("200010"),
    SIGNATURE_CHECK_ERROR("200011"),
    REPEAT_DATA_ERROR("200012"),
    FILE_FORMAT_ERROR("200013"),
    CONTENT_TOO_LONG_ERROR("200014"),
    FILE_SIZE_ERROR("200015"),
    ROLE_ID_ERROR("200016"),
    DATA_ERROR("200017"),
    PASSWORD_ERROR("200018"),
    GROUP_NAME_ERROR("200019"),
    GROUP_SAVE_ERROR("200020"),
    GROUP_MODIFIED_ERROR("200021"),
    GROUP_DELETE_ERROR("200022"),
    GROUP_REMOVE_ERROR("200023"),
    MENU_ID_NAME_ERROR("200024"),
    UNMODIFIED_DATA("200025"),
    MODIFIED_DATA_ERROR("200026"),
    DATA_NOT_DELETE("200027"),
    QUERY_MENU_LIST_ERROR("200028"),
    QUERY_MENU_ERROR("200029"),
    MENU_CODE_DUPLICATE("200030"),
    MENU_SAVE_ERROR("200031"),
    MENU_MODIFIED_ERROR("200032"),
    PARAM_ERROR("200033"),
    ROLE_NAME_DUPLICATED("200034"),
    ROLE_SAVE_ERROR("200035"),
    ROLE_MODIFIED_ERROR("200036"),
    ROLE_DELETE_ERROR("200037"),
    ROLE_ADD_GROUP_ERROR("200038"),
    ROLE_DELETE_GROUP_ERROR("200039"),
    QUERY_ORGANIZATION_ERROR("200040"),
    QUERY_NODE_ERROR("200041"),
    SAVE_NODE_ERROR("200042"),
    MODIFIED_NODE_ERROR("200043"),
    DELETE_NODE_ERROR("200044"),
    FILE_SAVE_ERROR("200045"),
    NO_CHOOSE_ERROR("200046"),
    GROUP_NOT_EXIST("200047"),
    NOT_GROUP_OWNER("200048"),
    REMOTE_QUERY_ERROR("200049"),
    ADD_FACTOR_ERROR("200050"),
    DECREASE_FACTOR_ERROR("200051"),
    OVER_PARAMS_NUM("200052"),
    REDIS_SERVICE_ERROR("200053"),
    ORG_NOT_EXIST("200054"),
    INSERT_ERROR("300001"),
    UPDATE_ERROR("300002"),
    DELETE_ERROR("300003"),
    QUERY_ERROR("300004"),
    DATABASE_CONNECT_ERROR("300005"),
    TRANSACTION_TIMEOUT_ERROR("300006"),
    DATABASE_NOT_GET_CONNECTION_ERROR("300007"),
    DELETE_CARD_SUBJECT_ERROR("300010"),
    DELETE_CARD_WARNING_ERROR("300011"),
    SHARE_ERROR("300012"),
    SELECT_SHARE_ERROR("300013"),
    DELETE_SHARE_ERROR("300014"),
    SUBSCRIBE_ERROR("300015"),
    SELECT_SUBSCRIBE_ERROR("300016"),
    DELETE_SUBSCRIBE_ERROR("300017"),
    TAB_ALREADY_EXIST("300018"),
    TAB_HAVE_CONTENT("300019"),
    DELETE_TAB_ERROR("300020"),
    RESOURCE_NOT_EXIST("300021"),
    UPDATE_TODO_STATUS_ERROR("300022"),
    TODO_NOT_EXIST("300023"),
    WARNING_IS_EXIST("300024"),
    TRACK_IS_EXIST("300025"),
    MAIN_RESPONSIBILITY_EMPTY("300026"),
    INDEX_DATA_EMPTY("300027"),
    UM_QUERY_EMPTY("300028"),
    TIME_DIMENSION_ERROR("300029"),
    WARNING_NAME_ERROR("300030"),
    WARNING_CARD_ERROR("300031"),
    DIMENSION_DATA_EMPTY("300032"),
    WARNING_RULE_GT_ERROR("300033"),
    WARNING_RULE_LT_ERROR("300034"),
    NO_AUTH_OPERATE_ERROR("300035"),
    WARNING_ID_EMPTY("300036"),
    CAN_NOT_SELECT_PLAN("300037"),
    HAVE_TRACKED_ERROR("300038"),
    DIMENSION_CREATE_ERROR("300039"),
    QUERY_NOTICE_ERROR("300040"),
    REVERT_NOTICE_ERROR("300041"),
    NOTICE_NOT_EXIST("300042"),
    NOTICE_ID_EMPTY("300043"),
    NOTICE_DETAIL_ERROR("300044"),
    NOTICE_MAY_DELETED_ERROR("300045"),
    NOTICE_CONTENT_ERROR("300046"),
    TITLE_TOO_LONG("300047"),
    CONTENT_TOO_LONG("300048"),
    SCOPE_EMPTY("300049"),
    ATTACHMENT_TOO_LARGE("300050"),
    NOTICE_SYSTEM_ERROR("300051"),
    NOTICE_ATTACHMENT_SYSTEM_ERROR("300052"),
    PUBLISH_NOTICE_SYSTEM_ERROR("300053"),
    REMOVE_USER_RESOURCE_ERROR("300054"),
    RECEIVER_NOT_EXIST("300055"),
    PLAN_SELECTED_ERROR("500018"),
    QUESTION_NOT_EXIST("300056"),
    PLAN_NOT_ACTIVE("300057"),
    RESOURCE_PRAISE_ERROR("300058"),
    RESOURCE_UPDATE_PRAISE_ERROR("300059"),
    RESOURCE_COUNT_PRAISE_ERROR("300060"),
    SELECT_PRAISE_DETAILS_ERROR("300061"),
    SHARE_UNIQUE_ERROR("300062"),
    ADD_CARD_INFO_REPEAT("999999"),
    RESOURCE_SUBJECT_SELECT_ERROR("600001"),
    RESOURCE_CARD_SELECT_ERROR("600002"),
    RESOURCE_PICTURE_SELECT_ERROR("600003"),
    RESOURCE_MAP_SELECT_ERROR("600004"),
    RESOURCE_CHART_SELECT_ERROR("600005"),
    RESOURCE_REMOVE_ERROR("600006"),
    RESOURCE_SELECT_ERROR("600007"),
    RESOURCE_SELECT_DETAIL_ERROR("600008"),
    RESOURCE_SUBJECT_DELETE_ERROR("600009"),
    RESOURCE_SELECT_NULL_ERROR("600010"),
    RESOURCE_DELETE_SUBJECT_SUCCESS("600011"),
    RESOURCE_REMOVE_SUCCESS("600012"),
    RESOURCE_INSERT_PICTURE_SUCCESS("600013"),
    RESOURCE_INSERT_PICTURE_ERROR("600014"),
    RESOURCE_UPDATE_PICTURE_ERROR("600015"),
    RESOURCE_UPDATE_PICTURE_SUCCESS("600016"),
    RESOURCE_CHECK_PICTURE("600017"),
    RESOURCE_CHECK_USERNAME("600018"),
    RESOURCE_RELATION_TABLEAU_ERROR("600019"),
    RESOURCE_DELETE_PICTURE_ERROR("600020"),
    RESOURCE_DELETE_PICTURE_SUCCESS("600021"),
    RESOURCE_NO_DELETE_PICTURE("600022"),
    RESOURCE_YES_DELETE_PICTURE("600023"),
    RESOURCE_PICTURE_DETAIL_ERROR("600024"),
    RESOURCE_PICTURE_NAME_ERROR("600025"),
    RESOURCE_INSET_CARD_ERROR("600026"),
    RESOURCE_INSET_CARD_SUCCESS("600027"),
    RESOURCE_INSET_CARD_NULL("600028"),
    RESOURCE_INSET_UPDATE("600029"),
    RESOURCE_ADD_CARD_ERROR("600030"),
    RESOURCE_CHECK_CARD("600031"),
    RESOURCE_ADD_CARD_SUCCESS("600032"),
    RESOURCE_SELECT_CARD_DETAIL("600033"),
    RESOURCE_CHECK_NO_CARD("600034"),
    RESOURCE_DELETE_CARD_ERROR("600035"),
    RESOURCE_DELETE_CARD_SUCCESS("600036"),
    RESOURCE_DELETE_CARD_SUBJECT_ERROR("600037"),
    RESOURCE_YES_DELETE_CARD("600038"),
    RESOURCE_CHECK_SUBJECT_NAME("600039"),
    RESOURCE_INSERT_OR_UPDATE_ERROR("600040"),
    RESOURCE_EXPORT_SUBJECT_PDF_ERROR("600041"),
    RESOURCE_NO_SUBJECT_NAME("600042"),
    RESOURCE_COPY_SUBJECT_ERROR("600043"),
    RESOURCE_COPY_SUBJECT_SUCCESS("600044"),
    RESOURCE_SELECT_CHART_ERROR("600045"),
    RESOURCE_CHECK_CHART_NAME("600046"),
    RESOURCE_INSERT_CHART_ERROR("600047"),
    RESOURCE_INSERT_CHART_SUCCESS("600048"),
    RESOURCE_UPDATE_CHART_ERROR("600049"),
    RESOURCE_UPDATE_CHART_SUCCESS("600050"),
    RESOURCE_DELETE_CHART_ERROR("600051"),
    RESOURCE_DELETE_CHART_SUCCESS("600052"),
    RESOURCE_NO_DELETE_CHART_ERROR("600053"),
    RESOURCE_GET_USER_ERROR("600054"),
    RESOURCE_SUBJECT_NAME_NULL("600055"),
    REQUEST_PARAM_IS_NULL("600056"),
    CHECK_SYSTEM_CONFIG_CODE("600057"),
    SYSTEM_PARAM_CONFIG_NOT_EXIST("600058"),
    FILE_UPLOAD_ERROR("600059"),
    RESOURCE_PERMISSION_CARD_CHECK_FAIL("600060"),
    RESOURCE_PERMISSION_DIM_CHECK_FAIL("600061"),
    APP_LAYOUT_SUBJECT_UPDATE_ERROR("600062"),
    APP_LAYOUT_CARD_UPDATE_ERROR("600063"),
    APP_RESOURCE_SELECT_NO_DATA("600064"),
    RESOURCE_BY_QUOTE("666666"),
    CARD_INFO_EXCEPTION("400001"),
    QUERY_CARD_INFO_FAIL("400002"),
    NOT_FIND_CARD_ID("400003"),
    BEFORE_REPLACE_INFO_ERROR("400004"),
    SKETCHPAD_MATCH_REPORT_INFO("400005"),
    SEND_EMAIL_EXCEPTION("400006"),
    EXIST_SAME_TAB_NAME("400007"),
    UPDATE_CARD_INFO_EXCEPTION("400008"),
    PROGRAM_RUN_EXCEPTION("400009"),
    GET_MODEL_COUNT_EXCEPTION("400010"),
    GET_AMOUNT_EXCEPTION("400011"),
    RELEASE_LINK_ERROR("400012"),
    GET_COMPANY_INFO_EXCEPTION("400013"),
    QUERY_SPECIAL_ROLE_DATA_EXCEPTION("400014"),
    USER_NOT_COLLECTION_CARD("400015"),
    CARD_INFO_COUNT_EXCEPTION("400016"),
    QUERY_SHARES_WINDOW_EXCEPTION("400017"),
    QUERY_MY_CARD_EXCEPTION("400018"),
    NO_DATA("400019"),
    NO_PERMISSION_VIEW("400020"),
    APP_BUSINESS_SCENES("400021"),
    QUERY_WARNING_INFO_FAIL("400022"),
    QUERY_ACCOUNT_DATA_EXCEPTION("400023"),
    SAVE_FAIL_CARD_REPEAT("400024"),
    CARD_TEMPLATE_IS_NULL("400025"),
    ADD_CUSTOMER_CARD_FAIL("400026"),
    QUERY_SUB_TAB_EXCEPTION("400027"),
    DELETE_CARD_INFO_FAIL("400028"),
    SAVE_TAB_LIST_EXCEPTION("400029"),
    MOVE_MY_CARD_EXCEPTION("400030"),
    USER_ALREADY_EXIST("400031"),
    NOT_FIND_RULE_ORDER("400032"),
    SELECT_OPERATOR_STATUS_EXCEPTION("400033"),
    CARD_NAME_IS_NOT_NULL("400034"),
    CARD_ID_NOT_ALLOW_NULL("400035"),
    SUBJECT_ID_NOT_ALLOW_NULL("400036"),
    SUBJECT_DETAIL_SEARCH_EXCEPTION("400037"),
    MESSAGE_ID_NOT_ALLOW_NULL("400038"),
    LAYOUT_DETAIL_SEARCH_EXCEPTION("400039"),
    FILTER_CARD_DATA_EXCEPTION("400040"),
    MSG_SET_READED_EXCEPTION("400041"),
    ARRAY_PARSING_ERROR("500001"),
    NOT_LOGGED_IN("500002"),
    SYSTEM_ERROR("500003"),
    TRACKING_RECORD_NOT_FOUND("500004"),
    DESCRIPTION_IS_EMPTY("500005"),
    DESCRIPTION_TOO_LONG("500006"),
    TRACKING_RECORD_NOT_EXIST("500007"),
    TRACKING_IS_OFF("500008"),
    TRACKING_IS_DISABLED("500009"),
    MAIN_BLAME_IS_NULL("500010"),
    NOT_WITHIN_THE_SCOPE("500011"),
    OPERATION_COMPLETED("500012"),
    CALCULATION_FAILED("500013"),
    NAME_EXIST("500014"),
    CANNOT_BE_DELETED("500015"),
    IM_DELETE_GROUP_MEMBERS_FAILED("500016"),
    IM_DELETE_GROUP_FAILED("500017"),
    REPLY_CONTENT_FILE("500019"),
    EXT_REPORT_NAME("500020"),
    EXT_REPORT_URL("500021"),
    LARGE_SCREEN_NAME_EXIST("700001"),
    LARGE_SCREEN_NAME_TOO_LONG("700002"),
    LARGE_CONTENT_NAME_EXIT("700003"),
    LARGE_CONTENT_NAME_TOO_LONG("700004"),
    LARGE_CONTENT_IS_USED("700005"),
    LARGE_TEMPLATE_NAME_EXIST("700006"),
    LARGE_SCREEN_RELEASE_NOT_DELETE("700007"),
    LARGE_SCREEN_GET_HOME_DATA_FAILD("700008"),
    APP_GET_SALES_VOLUME_FAILD("800001"),
    APP_GET_FILTER_DATA_FAILD("800002"),
    APP_GET_PROFIT_TREND_FAILD("800003"),
    APP_GET_SALER_INFO_FAILD("800004"),
    APP_GET_SEARCH_CUST_INFO_FAILD("800005"),
    APP_GET_EMPLOYER_NUM_ERROR("800006"),
    APP_GET_PROFIT_COST_FAILD("800007"),
    APP_GET_TOTAL_SALES_FAILD("800008"),
    APP_PROD_CATEGORY_YIELD_RATE_FAIL("800098"),
    APP_GET_COUNT_RANKING_FAIL("800099"),
    API_NO_MAIN_CONFIG("810000"),
    API_NO_FAC_CONFIG("810001"),
    API_NO_AFC_CONFIG("810002"),
    API_ERROR_DATA("810003"),
    APP_ERROR_CITYSTAT("810004"),
    APP_ERROR_CITYTREND("810005"),
    APP_ERROR_CITY_CUSTLIST("810006"),
    APP_ERROR_CUST_STAT("810007"),
    APP_ERROR_CUSTTREND("810008"),
    APP_ERROR_CUST_CLASSLIST("810009"),
    APP_NO_SALER("810010"),
    APP_ZD_OA_SIGN_DECRYPT_FAIL("810011"),
    APP_ZD_OA_SIGN_IS_NOT_MATCH_ACCOUNT("810012"),
    SALER_IS_NO_ACCESS_PERMISSION("810013"),
    APP_SELECT_DATA_ERROR("210000"),
    APP_PARAM_ERROR("210001"),
    APP_EW_EGG_QUERY_ERROR("210002"),
    APP_USER_DEVICE_IS_FORBIDDEN("220001"),
    APP_USER_DEVICE_IS_NOT_EXIST("220002"),
    APP_USER_DEVICE_MAP_PARSE_FAIL("220003"),
    APP_USER_DEVICE_IS_EXIST("220004"),
    APP_USER_NOT_ENABLE_ERROR("220005"),
    APP_USER_ACCOUNT_IS_NOT_EXISTS("220006"),
    SMS_CODE_IS_INVALID("230001"),
    SMS_CODE_IS_ERROR("230002"),
    SMS_SEND_COUNT_IS_OUT_ERROR("230003"),
    ;
    ResultCode(String code) {
        this.code = code;
    }

    private String code;

    public static final String RESULT_CODE_PREFIX = "com.gsl.resultcode.";

    public String getCode() {
        return this.code;
    }


    @Override
    public String getMessage() {
        // 在spring中，为了随时都能取到当前请求的request对象，可以通过RequestContextHolder的静态方法getRequestAttributes()获取Request相关的变量
        try {
            return getMessage(RESULT_CODE_PREFIX + this.code);
        }catch (Exception e){
            log.warn("case error when convert code: {}, exception:{}",this.code,e.getMessage());
            return "";
        }

    }

    @Override
    public String getMessage(Object[] args) {
        try {
            return getMessage(RESULT_CODE_PREFIX + this.code,args);
        }catch (Exception e){
            log.warn("case error when convert code: {}, exception:{}",this.code,e.getMessage());
            return "";
        }
    }
}
