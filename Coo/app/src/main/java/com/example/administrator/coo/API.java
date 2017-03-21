package com.example.administrator.coo;

/**
 * Created by zhanglei on 2016/12/16.
 */

public class API {

    public final static String PoorUserID = "0781d3df-75c1-4a9b-a6a8-e381f0f8b555";

    /**
     * 项目类型id，根据此id获取项目类型下拉框
     */
    public final static String PROJECT_TYPE_ID = "dcf6c132-496f-4b3c-8c18-ece375a242f1";

    public final static String CITY_ID = "130500000000";

    public final static String DATA = "data";
    public final static String TYPE = "type";

    //政策法规列表页向详情页传数据的key
    public final static String POLICY_KEY = "policy_key";
    //家庭成员列表页跳转到详情页传递数据所用的key
    public final static String MEMBER_KEY = "member_key";

    public final static int BI3_TYPE = 1;
    public final static int BI4_TYPE = 2;
    public final static int INCOME_TYPE = 3;
    public final static int LIFE_TYPE = 4;
    public final static int PRODUCTION_TYPE = 5;
    public final static int REMOVAL_TYPE = 6;

    public static String apiKey = "UdtdJlz51PcyzCt4doNcIs6Lrc7avGIK";
    public static String apiSecret = "7tnrNP0qWG7WQtVF8SQqGNxKvkicYgy6";

    /**
     * 请求参数:
     * 必须：
     * api_key
     * api_secret
     * 单选项:
     * image_url 图片的URL
     * image_file 一个图片，二进制文件，需要用post multipart/form-data的方式上传。
     */
    public static String URL = "https://api-cn.faceplusplus.com/cardpp/v1/ocridcard";

    /**
     * 接口的基础部分
     * http://172.16.40.229:8011
     * http://172.16.18.88:8011
     * http://172.16.41.6:33791
     */
    public static final String BASE_URL = "http://172.16.18.88:8011";

    /**
     * 登录的接口
     * 请求方式：POST
     * 参数：
     * UserName 用户名
     * UserPwd   密码
     */
    public static final String LOGIN_URL = BASE_URL + "/api/JZFP/Sys/Login";

    /**
     * 获取添加贫困户所有所需字典项
     * 请求方式：GET
     */
    public static final String POORUSERFORM_URL = BASE_URL + "/api/JZFP/PoorUser/GetPoorUserForm";

    /**
     * 获取添加贫困户家庭成员所有所需字典项
     * 请求方式：GET
     */
    public static final String MEMBERDATA_URL = BASE_URL + "/api/JZFP/PoorUser/GetPoorUserFmForm";

    /**
     * 根据父id获取父id的内容
     * 请求方式:GET
     * 参数：DicID 父id
     */
    public static final String GETDICINFO_URL = BASE_URL + "/api/JZFP/Sys/GetDicInfo?DicID=";

    /**
     * 获取地址下拉栏的内容
     * 请求方式：POST
     * 参数：pID
     */
    public static final String GETADDRESS_URL = BASE_URL + "/api/JZFP/Sys/GetSonDic?pID=";

    /**
     * 添加贫困户的接口
     * 请求方式：POST
     * 参数：见LowIncomeFamilyBean中的字段名（要传所有字段）
     */
    public static final String ADD_FAMILY_URL = BASE_URL + "/api/JZFP/PoorUser/AddPoorUser";

    /**
     * 添加贫困户家庭成员的接口
     * 请求方式：POST
     * 参数:见FamilyMemberBean中的字段名（要传所有字段）
     */
    public static final String ADDPOORUSERFM_URL = BASE_URL + "/api/JZFP/PoorUser/AddPoorUserFM";

    /**
     * 获取贫苦户列表
     * 请求方式:POST
     * 参数：
     * page	当前页码				必填
     * rows	每页行数				必填
     * xian	要查寻的县ID			可选
     * xiang 要查询的乡ID		可选
     * cun	要查询的村ID			可选
     * sxid	贫困户属性ID			可选
     */
    public static final String GET_LOWINCOMEFAMLIY_URL = BASE_URL + "/api/JZFP/PoorUser/GetPoorUserList";

    /**
     * 获取家庭成员列表
     * 请求方式：POST
     * 参数：
     * page	当前页码				必填
     * rows	每页行数				必填
     * PoorUserID	贫困户ID		必填
     */
    public static final String GET_MEMBERLIST_URL = BASE_URL + "/api/JZFP/PoorUser/GetPoorUserFmList";

    /**
     * 获取政策法规列表
     * 请求方式：GET
     * 参数：
     * page 不解释啦
     * pagenum  每页返回的数量
     * http://172.16.18.37:8787/test/select.php?page=1&pagenum=8
     * http://172.16.18.37:8787/test/test.php?method=select&page=
     */
    public static final String GET_POLICYLIST_URL = "/test/test.php?method=select&page=1&pagenum=20";

    /**
     * 添加单位帮扶信息
     * 请求方式：POST
     * 参数：
     * CunID	村庄编号    必填
     * TraTtitle	标题    必填
     * TraContent	内容    必填
     */
    public static final String TRACEADD_URL = BASE_URL + "/api/JZFP/TraceCompany/TraceAdd";

    /**
     * 获取添加单位帮扶信息的下拉菜单内容
     * 请求方式：POST
     * 参数：NULL
     */
    public static final String TRACEPOORCUN_URL = BASE_URL + "/api/JZFP/TraceCompany/TracePoorCun";

    /**
     * 获取单位帮扶信息列表
     * 请求方式：POST
     * 参数：
     * page	当前页码				必填
     * rows	每页行数				必填
     * cpName	单位名称			可选
     * cunName	村庄名称			可选
     * personName	责任人名称	可选
     */
    public static final String TRACELIST_URL = BASE_URL + "/api/JZFP/TraceCompany/TraceList";

    /**
     * 删除单位跟踪
     * 请求方式：POST
     * 参数：
     * TCID	单位跟踪信息编号  必填
     */
    public static final String TRACEDELETE_URL = BASE_URL + "/api/JZFP/TraceCompany/TraceDelete";

    /**
     * 修改单位跟踪信息
     * 请求方式:POST
     * 参数：
     * CunID	村庄编号				必填
     * TraTtitle	标题			    必填
     * TraContent	内容			    必填
     * TCID	跟踪编号			        必填
     */
    public static final String TRACEUPDATE_URL = BASE_URL + "/api/JZFP/TraceCompany/TraceUpdate";

    /**
     * 获取添加项目跟踪项目项
     * 请求方式：GET
     * 参数：无
     */
    public static final String GETPROJECTFORM_URL = BASE_URL + "/api/JZFP/Project/GetProjectForm";

    /**
     * 获取添加项目跟踪项目建设内容项
     * 请求方式:GET
     * 参数：Pid
     */
    public static final String GETPROJECTCONTENTLIST_URL = BASE_URL + "/api/JZFP/Project/GetProjectContentList?Pid=";

    /**
     * 获取项目跟踪列表
     * 请求方法：POST
     * page	当前页码				        必填
     * rows	每页行数				        必填
     * ptype	要查询的项目类型			可选
     * pctype	要查询的项目子类型		可选
     * pname	项目名称				    可选
     */
    public static final String PROJECTTRACELIST_URL = BASE_URL + "/api/JZFP/Project/ProjectTraceList";

    /**
     * 添加项目跟踪
     * 请求方式：POST
     * 参数见实体：
     */
    public static final String ADDTRACEPROJECT_URL = BASE_URL + "/api/JZFP/Project/AddTraceProject";

    /**
     * 获取项目列表
     * 请求方式：POST
     * 参数：
     * page	当前页码				    必填
     * rows	每页行数				    必填
     * xian	要查寻的县ID			    可选
     * xiang	要查询的乡ID		    可选
     * cun	要查询的村ID			    可选
     * ptype	要查询的项目类型		可选
     * pctype	要查询的项目子类型	可选
     * sxid	项目名称				    可选
     */
    public static final String PROJECTLIST_URL = BASE_URL + "/api/JZFP/Project/ProjectList";

    /**
     * 贫困户人员列表
     * 请求方式：POST
     * 参数：
     * CountryID;
     * XiangID;
     * CunID;
     */
    public static final String POORUSERLIST_URL = BASE_URL + "/api/JZFP/Project/PoorUserList";

    /**
     * 获取与项目相关人员列表
     * 请求方式:POST
     * 参数：
     * pid;
     * pcid;
     */
    public static final String PSRALATIONQITALIST_URL = BASE_URL + "/api/JZFP/Project/PSRalationQiTaList";

    /**
     * 删除项目相关人员
     */
    public static final String DPSQT_URL = BASE_URL + "/api/JZFP/Project/DPSQT";

    /**
     * 获取建设内容的列表
     * 请求方式：POST
     * 参数：
     * page	当前页码				必填
     * rows	每页行数				必填
     * Pid	要查寻的项目ID		必填
     */
    public static final String PROJECTCONTENTLIS_URL = BASE_URL + "/api/JZFP/Project/ProjectContentList";

    /**
     * 添加相关人员
     * 请求方式：POST
     * 参数:
     * PID:"3a82b1ab-ab3c-46f9-8af6-98f59e41e046",
     * PCID:"2d7a8a7b-cac2-4cbf-a1a1- 4b6a58190f34",
     * SYRID:"2D65C46C-5776-4E76-A9BC-02DDB5971AD7,31B9E28A-5393-4F89-BF71-B721F11F380C",
     * BeiZhuXinXi:"内容测试"
     */
    public static final String AddPSQT_URL = BASE_URL + "/api/JZFP/Project/AddPSQT";

    /**
     * 获取贫困村、贫困户、贫困人口统计信息
     * 请求方式：GET
     * 参数：？XianID=''&XiangID=''&year=2017
     */
    public static final String STATICSDATA_URL = BASE_URL + "/api/JZFP/CartoGram/PinkunRenkouData";

    /**
     * 获取贫困类型统计信息
     * 请求方式：POST
     * 参数：
     * category	统计类别			贫困户 1 返贫户2  脱贫户3    必填
     * xianid	县编号			                            可选
     * xiangid	乡编号			                            可选
     * quyutype	区域类型				                        必填
     * 1县2乡3村
     * sbbzid	识别标准编号		            预留	            可选
     * Year	年度		                        预留	            可选
     */
    public static final String POORTOTAL_URL = BASE_URL + "/api/JZFP/CartoGram/PoorTotal";


}
