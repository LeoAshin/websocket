package com.websocket.util;


/**
 * Created by andilyliao on 16-4-2.
 */
//常量类
public class CommonConst {
    public static final String SLASH = "/";
    public static final String SPLITOR = "!=end=!";//redis的key的华丽的分隔符
    public static final String BLANK = "";
    public static final String BLANKSPACE = " ";
    public static final String PUBSET = "PUBSET";//pubset前缀
    public static final String OFFSET = "OFFSET";//offset前缀
    public static final String RECIVE = "RECIVE";//消费者是否还在持续获取数据
    public static final String NOTIFY = "HI";//用作通知的字符串
    public static final String ERROR = "error";
    public static final String INVITE = "invite";
    public static final Integer REWARD = 5;
    public static final String MONEY = "money";
    public static final String USERLIST = "userList";
    public static final String OK = "OK";
    public static final String SYSTEM_PROPERTIES = "/system.properties";
    public static final String TTL = "ttl";
    public static final String MARKORDER = "markOrder";
    public static final String CHAR = "[\\u4e00-\\u9fa5]";
    public static final String LOWERCASE = "[a-z]";
    public static final String UPPERCASE = "[A-Z]";
    public static final String NUMCASE = "[0-9]";
    public static final String HASHTAG = "#";
    public static final String MALE = "男";
    public static final String FEMALE = "女";
    public static final String REFUNDMETHOD = "refundMethod";//退款方式
    public static final String REFUNDSTATUS = "refundStatus";//退款状态
    public static final String REFUNDFEE = "refundFee";//退款手续费
    public static final String CHECKREFUNDTIME = "checkRefundTime";//审核退款时间
    public static final String APPLYREFUNDTIME = "applyRefundTime";//申请退款时间
    public static final String TIMESTART = "00:00:00:";
    public static final String TIMEEND = "23:59:59";
    public static final String CREATESTARTTIME = "createStartTime";//创建时间
    public static final String LASTUPDATETIME = "lastUpdateTime";//最后更新时间
    public static final String APPLYTIME = "applyTime";//菜品提交审核时间
    public static final String DEALTIME = "dealTime";//菜品审批处理时间
    public static final String LOCKSTATUS = "lockStat";//0是正常 1是锁定
    public static final String FLAG = "flag";
    public static final String CAROUSEL = "carousel";
    public static final String STARTTIME = "startTime";
    public static final String ENDTIME = "endTime";
    public static final String DELUPHURL = "头像被删除,原因：";
    public static final String DELUPURLS = "相册被删除,原因：";
    public static final String LOCK = "被锁定";
    public static final String UNLOCK = "解锁";
    public static final String DEFAULURL = "http://huisheng.ufile.ucloud.cn/wgtx20161020.png";
    public static final String LIVEDEFAULURL = "http://huisheng.ufile.ucloud.cn/zbwg20161020.png";
    public static final String REASON = "reason";//菜品审核驳回原因

    //直播相关
    public static final String LIVE = "live";
    public static final String GIFTS = "gifts";
    public static final String URL = "url";
    public static final String PRICE = "price";
    public static final String CPRICE = "cPrice";
    public static final String LIVEGIFTBEAN = "liveGiftBean";
    public static final String GIFT_NOT_EXITS = "GIFT_NOT_EXITS"; //礼物不存在
    public static final String LIVEMSG = "liveMsg"; //直播消息推送
    public static final String ROOMNO = "roomNo"; //房间号
    public static final String MSGID = "msgId";
    public static final String LIVE_MSG = "LIVE_MSG";
    public static final String AHTOTALFANS = "ahTotalFans";  //主播粉丝数量
    public static final String AHTOTALONLINE = "ahTotalOnline";//主播在线时长
    public static final String AHTOTALINCOME = "ahTotalIncome";//主播收入
    public static final String SORT = "sort";//礼物排序

    //queue模式字符串字面量
    public static final String TYPE = "type";//Mode中queue模式作为值
    public static final String ZERO = "0";
    public static final String ONE = "1";
    public static final String TWO = "2";
    public static final String THREE = "3";
    public static final String FOUR = "4";
    public static final String FIVE = "5";
    public static final Float FIVE_FLOAT = 5f;
    public static final String SIX = "6";
    public static final String SEVEN = "7";
    public static final String EIGHT = "8";//手动修改余额标记
    public static final String FIFTEEN = "15";
    public static final Short ZERO_SHORT = 0;
    public static final Short ONE_SHORT = 1;
    public static final String F = "f";
    public static final Long ZERO_LONG = (long) 0;
    public static final Long ONE_LONG = (long) 1;
    public static final Long NEGATIVE_ONE_LONG = (long) -1;
    public static final Integer NEGATIVE_ONE = -1;
    public static final Integer POSITIVE_ONE = 1;
    public static final Long NEGATIVE_TEW_LONG = (long) -2;
    public static final String STAR = "*";
    public static final String SCALE1 = "scale1";
    public static final String SCALE2 = "scale2";
    public static final String PAYTIME = "payTime";
    public static final String CHECKTIME = "checkTime";
    public static final String VAILDTIME = "vaildTime";
    public static final String INVITEREWARD = "inviteReward";
    public static final String REGWEWARD = "regReward";
    public static final String PAYOVERTIME = "payOverTime";
    public static final String BILLING = "billing";
    public static final String BILLINGCOS = "billingCos";

    public static final String TOK = "token";
    public static final String UID = "uId";
    public static final String _01 = "status";
    public static final String _02 = "error";
    public static final String _03 = "tokenId";
    public static final String _04 = "mobile";

    public static final String _05 = "pwd";
    public static final String _28 = "orderTime";
    public static final String _43 = "rname";
    public static final String _44 = "addr";

    public static final String MERCHANTC = "MerchantC";
    public static final String IMPORTDATAC = "ImportDataC";
    public static final String REGISTER = "register";
    public static final String SIGNIN = "signIn";
    public static final String IMPORTDATA = "importData";
    public static final String DETAIL = "detail";

    public static final String RESTAURANT = "res";
    public static final String RID = "rId";
    public static final String FLOOR = "floor";
    public static final String LOGIN = "login";
    public static final String KEY = "key";
    public static final String EID = "eId";
    public static final String DISHID = "dishId";
    public static final String KEYWORD = "kw";
    public static final String PAYMETHOD = "payMethod";
    public static final String PAYAMOUNT = "payAmount";
    public static final String RIDS = "rIds";
    public static final String ALL = "all";
    public static final String TABLES = "tables";
    public static final String SYSTEM = "system";
    public static final String RECORD = "record";

    //bean
    public static final String USERBEAN = "user";
    public static final String ORDERBEAN = "orderBean";
    public static final String EVALBEAN = "evalBean";
    public static final String DISHBEAN = "dishBean";
    public static final String RESTAURANTBEAN = "restaurantBean";
    public static final String BIGGIEBEAN = "biggieBean";
    public static final String CHARGEPARAMS = "chargeParams";
    public static final String BIGGIEEVALBEAN = "biggieEvalBean";

    public static final String PATH = "path";
    public static final String JSONVERSION = "jsonVersion";
    public static final String JSONVERSION_RES = "jsonVersion_res";
    public static final String JSONVERSION_PUBLIC = "jsonVersion_public";
    public static final String JSON = ".json";
    public static final String JSON_PUBLIC = "json_public";
    public static final String JSON_RES = "json_res";


    public static final String BALANCELIST = "balanceList";
    // errorCode值
    public static final String LBS_RES_NOT_EXITS = "LBS_RES_NOT_EXITS";//LBS中不存在该餐厅
    public static final String NO_DISH_FIND = "NO_DISH_FIND";//菜品分类不存在
    public static final String USR_TOK_NULL = "USR_TOK_NULL";   // 没有拿到TOKEN
    public static final String USR_SN_EXITS = "USR_SN_EXITS";   // 用户昵称已存在
    public static final String USR_NOT_EXITS = "USR_NOT_EXITS"; // 用户不存在
    public static final String USR_NOT_IN_RES = "USR_NOT_IN_RES"; // 用户不存在
    public static final String USR_EXITS = "USR_EXITS"; // 用户已存在
    public static final String USR_LOGIN_TIMEOUT = "USR_LOGIN_TIMEOUT"; // 登录失效
    public static final String PARAM_ERROR = "PARAM_ERROR";
    public static final String BALANCE_INSUFFICIENT = "BALANCE_IS_INSUFFICIENT"; //余额不足
    public static final String TABLE_HAS_BEEN_BOOKED = "TABLE_HAS_BEEN_BOOKED"; //桌子已被预订
    public static final String KEY_NOT_EXIST = "KEY_NOT_EXIST"; //key不存在
    public static final String KEY_NOT_EXPIRE = "KEY_NOT_EXPIRE"; //key没有设置生存时间
    public static final String USR_SMOBC_ERR = "USR_SMOBC_ERR";
    public static final String USR_PWD_ERR = "USR_PWD_ERR";
    public static final String USR_SIGN_TIMES_ERR = "USR_SIGN_TIMES_ERR";
    public static final String USR_NO_LOGIN = "USR_NO_LOGIN";
    public static final String USR_NO_INFO = "USR_NO_INFO";
    public static final String USR_FILE_TYPE_NULL = "USR_FILE_TYPE_NULL";
    public static final String USR_IMG_NOTSPORT = "USR_IMG_NOTSPORT";
    public static final String USR_NEWMOBILE_BAD = "USR_NEWMOBILE_BAD";
    public static final String USR_DEVICE_NOFOUND = "USR_DEVICE_NOFOUND";
    public static final String USR_ONLIY_IOS_ANDROID = "USR_ONLIY_IOS_ANDROID";
    public static final String USR_NICKNAME_ERR = "USR_NICKNAME_ERR";
    public static final String LONG_STR_NULL = "LONG_STR_NULL";
    public static final String LONG_STR_ERR = "LONG_STR_ERR";
    public static final String NUMBER_STR_NULL = "NUMBER_STR_NULL";
    public static final String NUMBER_STR_ERR = "NUMBER_STR_ERR";
    public static final String TYPE_ERR = "TYPE_ERR";
    public static final String MAIL_ERR = "MAIL_ERR";
    public static final String SORT_ERR = "SORT_ERR";
    public static final String IMG_URL_ERR = "IMG_URL_ERR";
    public static final String USR_INFO_INCOM = "USR_INFO_INCOM";
    public static final String RES_LIST_NULL = "RES_LIST_NULL";  // 餐厅列表为空
    public static final String PRAISE_EXITS = "PRAISE_EXITS";   // 该用户已经点过赞
    public static final String OVERDUE_PAYMENT = "OVERDUE_PAYMENT";//支付过期
    public static final String PAY_FAILED = "PAY_FAILED";//支付失败
    public static final String INSUFFICIENT_PAYMENT_AMOUNT = "INSUFFICIENT_PAYMENT_AMOUNT";//支付金额不足
    public static final String CODE_NOT_EXIST = "CODE_NOT_EXIST";//消费码不存在
    public static final String CODE_RES_NOT_MATCH = "CODE_RES_NOT_MATCH";//消费码与餐厅不匹配
    public static final String RES_NOT_EXIST = "RES_NOT_EXIST";//未查询到餐厅信息
    public static final String PARAM_INCOM = "PARAM_INCOM";//参数不全
    public static final String FOUREXITS = "FOUR_EXITS";//已经存在4个，请撤销一个再添加
    public static final String FIRSTLEVELEXITS = "FIRSTLEVEL_EXITS";//已经存在一个一级分类
    public static final String NO_TABLE_INFO_FIND = "NO_TABLE_INFO_FIND";//餐桌信息未找到
    public static final String INSERT_FAILED = "INSERT_FAILED"; //插入失败
    public static final String DELETE_FAILED = "DELETE_FAILED";  //删除失败
    public static final String RECBIGGIE_OVER = "RECBIGGIE_OVER";//推荐大咖过多
    public static final String BIGGIE_BEEN_RECOMMED = "BIGGIE_BEEN_RECOMMED";//大咖被推荐
    public static final String BIGGIE_BEEN_EVALED = "BIGGIE_BEEN_EVALED";//大咖发表过评价
    public static final String ORDER_REFUNDED = "ORDER_REFUNDED";//订单已退款

    public static final String ORDERNO = "order_no";
    public static final String APP = "app";
    public static final String CHANNEL = "channel";
    public static final String CURRENCY = "currency";
    public static final String CLIENTIP = "client_ip";
    public static final String SUBJECT = "subject";
    public static final String BODY = "body";


    //redis key
    public static final String LAYOUT = "layout";
    public static final String LAYOUT2 = "layout2";
    public static final String RES = "res";
    public static final String TRAINED = "trained";
    public static final String BIGGIELIST = "biggieList";
    public static final String RECOMBIGGIELIST = "recomBiggieList";
    public static final String EVALUATESTATUS = "evaluateStatus";
    public static final String RECOMMEND = "recommend";
    public static final String RECOMMENDFLG = "recommendFlg";
    public static final String EVALFLG = "evalFlg";
    public static final String RESFIRSTCLASS = "resFirstClass";
    public static final String RESSECONDCLASS = "resSecondClass";
    public static final String RECHARGELIST = "rechargeList";//充值流水列表 key
    public static final String RESPASSLIST = "resPassList";
    public static final String REMARK = "remark";

    public static final String OID = "oId";
    public static final String ORDERSITS = "orderSits";
    public static final String ORDERID = "ORDERID";
    public static final String ORDERDISHES = "orderDishes";
    public static final String ORDERED = "ordered";
    public static final String ORDEREDL = "orderedL";
    public static final String ORDERCODE = "orderCode";
    public static final String ONERES = "oneRes";
    public static final String ORDERA = "orderA";
    public static final String ORDERB = "orderB";
    public static final String ORDERS = "orders";
    public static final String ORDERLIST = "orderList";
    public static final String DISH = "dish";
    public static final String INCODE = "inCode";
    public static final String CODE = "code";
    public static final String OLDPWD = "oldPwd";
    public static final String KEEPTIME = "keepTime";
    public static final String STATUS = "status";
    public static final String STAT = "stat";
    public static final String ALIID = "streamId";
    public static final String REFUNDREA = "refundRea";
    public static final String REFUNDAMOUNT = "refundAmount";
    public static final String MOBILE = "mobile";
    public static final String TYPEDETAIL = "typeDetail";
    public static final String AMOUNT = "amount";
    public static final String RNAME = "rName";
    public static final String NAME = "Name";
    public static final String PROVINCE = "province";
    public static final String ORDERTIME = "orderTime";
    public static final String OVERTIME = "over";
    public static final String TIME = "time";
    public static final String COS = "cos";
    public static final String KEEPUSE = "keepUse";
    public static final String EATTIME = "etaTime";
    public static final String RESTTIME = "restTime";
    public static final String RTIMEFROM = "rTimeFrom";
    public static final String RTIMETO = "rTimeTo";
    public static final String BTIMEFROM = "bTimeFrom";
    public static final String BTIMETO = "bTimeTo";
    public static final String WEEKFLG = "weekFlg";
    public static final String ADVDAY = "advDay";
    public static final String ADVTIME = "advTime";
    public static final String BKTIME = "bkTime";
    public static final String BKTIMEFROM = "bkTimeFrom";
    public static final String BKTIMETO = "bkTimeTo";
    public static final String SHORTERTIME = "shorterTime";
    public static final String USETIME = "useTime";
    public static final String PERSON = "person";
    public static final String EVALUATE = "Evaluate";
    public static final String DELAY = "delay";
    public static final String COLLECT = "collect";
    public static final String PRAISE = "praise";
    public static final String PART = "part";
    public static final String CLASSA = "classA";
    public static final String CLASSB = "classB";
    public static final String LFTE = "lfte";
    public static final String MAPID = "mapId";
    public static final String ID = "id";
    public static final String RPRAISE = "rPraise";
    public static final String IDCARD = "idCard";
    public static final String RESPH = "resph";
    public static final String MOBTOUID = "mobToUId";
    public static final String UIDTOMOB = "uIdToMob";
    public static final String RESVEDIO = "resvedio";
    public static final String BOOKEDNUM = "bookedNum";
    public static final String RSTAR = "rStar";
    public static final String EVALNUM = "evalNum";

    public static final String COLLECTED = "collected";
    public static final String LOOKME = "lookMe";
    public static final String LOOKTOME = "lookToMe";
    public static final String IM = "IM";
    public static final String ACTION = "action";
    public static final String FACE = "face";
    public static final String FIRE = "fire";
    public static final String CLOTH = "cloth";
    public static final String FRIEND = "friend";
    public static final String PREFRIEND = "prefriend";
    public static final String PINGKEY = "pingPay";
    public static final String ALIPAY = "alipay";
    public static final String WX = "wx";
    public static final String UPACP = "upacp";
    public static final String GIFT = "gift";
    public static final String BIGGIE = "biggie";
    public static final String COUNT = "count";
    public static final String SOURCE = "source";
    public static final String TABLE = "table";
    public static final String TABLEJSON = "_table.json";
    public static final String TABLEID = "tableId";
    public static final String ROWS = "rows";
    public static final String TOTAL = "total";
    public static final String TSTATUS = "tStatus";
    /**********
     * 运营端
     ***********/
    /*begin llj 2016-07-21*/
    public static final String LEVEL = "level";
    public static final String OPERATE = "operate";
    public static final String OPERATELOGIN = "operateLogin";
    public static final String OPERATEMOB = "operateMob";
    public static final String MERCHANTID = "MerchantId";
    public static final String LEGEL = "legal";
    public static final String LEGELMOBILE = "legalMobile";
    public static final String RSTATUS = "rStatus";
    public static final String CHAIN = "chain";/* 所属连锁集团 */
    public static final String CONTRACTID = "contractId";/* 合同编号 */
    public static final String CREDENTIALS = "credentials";/* 资质信息 */
    public static final String LICENCEURL = "licenceUrl";/* 营业执照照片 */
    public static final String USERNAME = "userName";/* 登录用户名 *//*初始密码123456或者发短信*/
    public static final String DELFLAG = "delFlag";/*餐厅是否被删除标记*//*0：未删除，1：删除*/
    /*end llj 2016-07-21*/

    public static final String USERINFO = "userInfo";
    public static final String ORDER = "order";
    public static final String STREAM = "stream";
    public static final String TRADE = "trade";
    public static final String TRADEDISH = "tradeDish";
    public static final String TOTALAMOUNT = "totalAmount";


    public static final String NICKNAME = "nicName";
    public static final String REGTIME = "regTime";
    public static final String LASTLOGINTIME = "lastLoginTime";
    public static final String STREAMID = "streamId";
    public static final String PAYTYPE = "payType";
    public static final String PHONE = "phone";
    public static final String BIRTH = "birth";
    public static final String CITY = "city";
    public static final String PHURL = "phUrl";
    public static final String SEX = "sex";
    public static final String RESERVEMOB = "reserveMob";
    public static final String SITS = "sits";
    public static final String LAYOUTID = "layoutId";
    public static final String DISCOUNT = "discount";
    public static final String ORDERCOS1 = "orderCos1";
    public static final String ORDERCOS2 = "orderCos2";
    public static final String EVERY = "every";
    public static final String RESADDR = "resAddr";
    public static final String RESEVA = "reseva";
    public static final String RESSTAR = "resstar";
    public static final String DISHSTAR = "dishStar";
    public static final String CONTEXT = "context";
    public static final String FEEDBACK = "feedback";
    public static final String PH = "ph";
    public static final String PERSONIMAGE = "personImage";
    public static final String REFUNDTIME = "refundTime";
    public static final String REPLY = "reply";

    /*begin llj 2016-06-04*/
    /*餐厅的hbase*/
    //public static final String RID = "rid";// 餐厅ID
    //public static final String RNAME = "rName";// 餐厅名称
    //public static final String MAPID = "mapId";// 餐厅位置点
    public static final String PERPRICE = "perPrice";// 餐厅人均消费
    //public static final String RPRAISE = "rPraise";// 餐厅赞数
    public static final String RSIGN = "rSign"; // 餐厅签名
    public static final String RTIME = "rTime";// 餐厅营业时间
    public static final String RADDR = "rAddr";// 餐厅地址
    public static final String TABNUM = "tabNum";// 餐厅可订桌数目
    public static final String EVALIST = "evaList";// 餐厅评价列表
    public static final String RPURLS = "rpUrls";// 餐厅图片url
    public static final String BANK = "bank";
    public static final String ACCOUNT = "account";
    public static final String RMOBILE = "rMobile"; // 餐厅电话
    public static final String RTOTAL = "rTotal";// 餐厅总座位数
    //public static final String SHORTERTIME = "shorterTime";//时间间隔
    //public static final String USETIME = "useTime";//可用时间段
    //public static final String CITY = "city";// 所属位置（市）
    public static final String REGION = "region";// 所属位置（区、县）
    public static final String CIRCLE = "circle";// 所属商圈
    public static final String MCATEGORY = "mCategory";// 大分类
    public static final String SCATEGORY = "sCategory";// 小分类
    public static final String LESSPRICE = "lessPrice";// 起订价
    public static final String ACCOUNTHOLDER = "accountHolder"; //开户人

    //es 不分词
    public static final String CIRCLE_NOT = "circle_not";
    public static final String CITY_NOT = "city_not";
    public static final String MCATEGORY_NOT = "mCategory_not";
    public static final String RNAME_NOT = "rName_not";
    public static final String REGION_NOT = "region_not";
    public static final String SCATEGORY_NOT = "sCategory_not";


    /*begin llj 2016-06-06*/
    public static final String CLASSURL = "classUrl";// 菜品类型URL
    public static final String PREORDERTIME = "preOrderTime";// 预约提前时间
    //public static final String KEEPTIME = "keepTime";// 保留座位时间
    //public static final String KEEPUSE = "keepUse";// 占用座位时间
    //public static final String FLOOR = "floor";// 层数
    public static final String POSX = "posx";// 定位坐标x
    public static final String POSY = "posy";// 定位坐标y
    public static final String POSXY = "posxy";// 定位坐标
    /*end llj 2016-06-06*/
    /*ES相关*/
    /*菜品*/
    //public static final String DISHID = "dishId";//菜品id
    public static final String DISHNAME = "dishName";//菜品名
    public static final String DISHAMOUNT = "dishAmount";//菜品数量
    public static final String DISHPRICE = "dishPrice";//菜品单价
    public static final String DISHHURL = "dishHUrl";// 菜品首图
    public static final String DISHURLS = "dishUrls";// 菜品图片
    public static final String DISHCLASS = "dishClass";// 菜品分类
    //    public static final String DISHSTAR  = "dishStar";// 菜品评星
    public static final String DISHMEMO = "dishMemo";// 菜品介绍
    public static final String DISHVURL = "dishVUrl";// 菜品视频
    public static final String DISHALL = "dishAll";//菜品总价
    /*end llj 2016-06-04*/

    /*begin llj 2016-05-28 */
    public static final String PWD = "pwd";
    public static final String NP = "np";
    public static final String TOKENID = "tokenId";
    //    public static final String DEVICEID = "deviceId";
    public static final String DEVICEID = "deviceId";
    public static final String UPHURL = "phUrl";
    public static final String HEIGHT = "height";
    public static final String CONSTELLATION = "constellation";
    public static final String EMSTATE = "emState";
    public static final String SIGNATURE = "signature";
    public static final String OCCUPATION = "occupation";
    public static final String INCOME = "income";
    public static final String EDUCATION = "education";
    public static final String UPURLS = "upUrls";
    public static final String ULAB = "uLab";
    public static final String CMEDUCATION = "cmEducation";
    public static final String CMINCOME = "cmIncome";
    public static final String CMOCCUPATION = "cmOccupation";
    public static final String CMHEIGHT = "cmHeight";
    public static final String CMCITY = "cmCity";
    public static final String BALANCE = "balance";//账户余额
    public static final String ACTIVITYRECHARGE = "activityRecharge";
    public static final String ACTIVITYLIST = "activityList";
    public static final String ACTIVITY = "activity";
    public static final String ACTIVITYEND = "activityEnd";
    public static final String ACTNAME = "actName";
    public static final String PERCOUNT = "perCount";
    /*end llj 2016-05-28 */
    //LBS
    public static final String ADDRESS = "address";//lbs必要字段
    public static final String COORDTYPE = "coord_type";//lbs必要字段
    public static final String LATITUDE = "latitude";
    public static final String LONGITUDE = "longitude";

    /*反馈意见相关*/
    public static final String FDK = "fdk";//反馈意见
    public static final String TIMESTAMP = "timestamp";//时间戳

    /*账户相关*/
    public static final String STARTIDX = "startIdx";//起始Index
    public static final String NUM = "num";//个数
    public static final String DETAILS = "details";//redis中账户明细key
    public static final String RECHARGE = "recharge";//redis中账户明细key
    public static final String FIRSTRECHARGE = "firstRecharge";//redis中账户明细key

    /*邂逅人相关*/
    public static final String ENCOUNTER = "Encounter";//redis通用
    public static final String ENCOUNTERFM = "EncounterFM";//redis中女
    public static final String ENCOUNTERM = "EncounterM";//redis中男

    public static final String ENCOUNTELOG = "EncounterLog";//hbase中叉桃
    public static final String LMOBILE = "lmobile";//邂逅人手机号
    public static final String LIKE = "like";//叉桃标记，1桃，0叉
    public static final String DEL = "DEL";//

    /*券码生成相关*/
    public static final String CODEGEN = "codeGen";//券码生成前缀
    public static final String ORDERNUMBFRONT = "orderNumbFront";//订单号前4位
    public static final String ORDERNUMBEHIND = "orderNumbBehind";//订单号后7位
    public static final String USERID = "userId";//用户id
    public static final String CONSUMERCODE = "consumerCode";//消费码
    public static final String RESID = "resId";//餐厅id
    public static final String AREACODE = "areaCode"; //区域码
    //时间格式
    public static final String DATEFORMAT1 = "yyyy-MM-dd";
    public static final String DATEFORMAT2 = "yyyy-MM-dd HH:mm";
    public static final String DATEFORMAT3 = "yyyy-MM-dd HH:mm:ss";
    public static final String DATEFORMAT4 = "yyyyMMdd";

    public static final String ZEROPOINT = " 00:00:00";
    public static final String MIDNIGHT = " 23:59:59";
    public static final String DATE = "date";
    public static final long ANHOUR = 3600000;
    public static final double SCORE = 1000;
    public static final double MAXSCORE = 999;
    public static final double DELSCORE = 9999;
    public static final Integer MAXSCOREINT = 999;


    //举报相关
    public static final String REPORT = "report";
    public static final String USERREPORT = "userReport";
    public static final String RESREPORT = "resReport";
    public static final String UNREAD = "unRead";

    //ping++
    public static final String PAYSTAT = "payStat";

    /********************************
     * 商家版相关begin
     ****************************************/
    public static final String RESLOGIN = "resLogin";
    public static final String USER = "user";
    public static final String MARK = "mark";
    public static final String RESMOB = "resMob"; //初始密码
    public static final String DISHSTATUS = "dishStatus"; //菜品状态
    public static final String CREATETIME = "createTime"; //菜品最后编辑时间
    public static final String SMTTIME = "smtTime";//用户下单时间
    public static final String FILEPATH = "filePath";//导出到Excel的服务器上位置
    public static final String MSG = "msg";
    public static final String ALLOW = "allow";
    public static final String REFUSE = "refuse";

    /*LBS相关数据*/
    public static final String AK = "ak";
    public static final String GEOTABLE_ID = "geotable_id";
    public static final String TITLE = "title";
    /********************************
     * 商家版相关end
     ******************************************/
    public static final String MOBILE_ = "01";
    public static final String TOKEN_ = "02";
    public static final String NUM_ = "03";
    public static final String PWD_ = "04";
    public static final String DEVICEID_ = "05";
    public static final String OUSER_ = "06";
    public static final String ROOMNO_ = "07";
    public static final String LIVESTATUS_ = "08";
    public static final String GROUPID_ = "09";
    public static final String CHANNELID_ = "10";
    public static final String RID_ = "11";
    public static final String NICKNAME_ = "12";
    public static final String REGTIME_ = "13";
    public static final String REALFLAG_ = "14";
    public static final String ISSIGNED_ = "15";
    public static final String ISRECOMMEND_ = "16";
    public static final String HASFACEPIC_ = "17";
    public static final String VID_ = "18";
    public static final String EID_ = "19";
    public static final String DATE_ = "20";
    public static final String REALNAME_ = "21";
    public static final String ORDERTIME_ = "23";
    public static final String TYPE_ = "24";
    public static final String ORDERID_ = "25";
    public static final String DISHID_ = "26";
    public static final String STREAMID_ = "29";
    public static final String UID_ = "33";
    public static final String STARTIDX_ = "35";
    public static final String FLG_ = "37";
    public static final String ACTID_ = "40";
    public static final String STATUS_ = "45";
    public static final String STARTTIME_ = "47";
    public static final String ENDTIME_ = "48";
    public static final String DISHSTATUS_ = "49";
    public static final String FLOOR_ = "52";
    public static final String DISHNAME_ = "54";
    public static final String FILEPATH_ = "55";
    public static final String BALANCE_ = "56";
    public static final String MSGID_ = "59";
    /**********
     * 运营端
     *************/
    public static final String RNAME_ = "56";
    public static final String CITY_ = "57";
    public static final String PARAMS_ = "58";
    public static final String OIDS_ = "61";
    public static final String NAME_ = "81";
    public static final String SOURCE_ = "82";
    public static final String FIRSTLEVEL_ = "62";
    public static final String SECONDLEVEL_ = "63";
    public static final String SCORE_ = "64";
    public static final String REASON_ = "67";//驳回原因;
    public static final String OLDFIRSTLEVEL_ = "68";
    public static final String DISHIDLIST_ = "69";//菜品IdList
    public static final String LOCKSTATUS_ = "70";//0是正常 1是锁定
    public static final String GIFTMONEY_ = "72";
    public static final String RECHARGE_ = "73";
    public static final String INDEX_ = "74";
    public static final String DISHCLASSBEANLIST_ = "75";
    public static final String IMGNAME_ = "76";
    public static final String IMGURL_ = "77";
    public static final String LAYOUTS_ = "79";//多个布局信息
    public static final String CSVNAMES_ = "80";//多个CSV文件名
    public static final String CID_ = "83";//APP版本号
    public static final String MCATEGORY_ = "85";
    public static final String USERNAME_ = "87";
    public static final String MID_ = "88";
    public static final String GROUPNAME_ = "89";
    public static final String RECOMMENDSTATUS_ = "90";
    public static final String DISHCLASS_ = "91";
    public static final String CONTEXT_ = "92";
    public static final String ID_ = "93";
    public static final String DATEFROM_ = "94";
    public static final String DATETO_ = "95";
    public static final String XNB_ = "96";
    public static final String RMB_ = "97";
    public static final String OUID_ = "98";
    public static final String NEWPWD_ = "99";
    public static final String TIME_ = "100";
    public static final String GID_ = "101";
    public static final String LGID_ = "102";


    //餐桌状态码
    public static final String TABLE_OPTIONAL = "0";
    public static final String TABLE_NOT_OPTIONAL = "1";
    public static final String TABLE_CHOSEN = "2";
    public static final String TABLE_IMAGE_EXISTS = "TABLE_IMGAE_EXISTS";
    public static final String UNOPTIONAL = "unoptional";
    public static final String SERVER_EXTREMELY = "server_extremely";
    public static final String HIVE_CONNECT_FAILED = "hive_connect_failed";
    public static final String LUCKY = "lucky";
    public static final String LUCKY_BUFFER = "buffer";
    public static final String LUCKY_BONUS = "lucky_bonus";
    public static final String COMMA = ",";
    public static final String IMG_NOT_EXIST = "IMG_NOT_EXIST";

    //jdbc
    public static final int MYSQL = 0;
    public static final int HIVE = 1;
    public static final String NO_DISH_INFO_FIND = "NO_DISH_INFO_FIND";
    public static final String OUSERC = "OUserC";
    public static final String SIGNUP = "signUp";
    public static final String OUSER = "ouser";
    public static final String OUSERLIST = "usersList";
    public static final String DELETEUSER = "deleteUser";
    public static final String RNAME_EXIST = "RNAME_EXIST";
    public static final String USR_BEEN_LOCKING = "USR_BEEN_LOCKING";
    public static final String FILE_ERROR = "FILE_ERROR";
    public static final String IMUID = "imuId";
    public static final String IMPASS = "imPass";
    public static final String GHOST = "ghost";
    public static final String PWD_CANNOT_BE_NULL = "PWD_CANNOT_BE_NULL";
    public static final String EMSTATE_CANNOT_BE_NULL = "EMSTATE_CANNOT_BE_NULL";
    public static final String NICKNAME_CANNOT_BE_NULL = "NICKNAME_CANNOT_BE_NULL";
    public static final String SEX_CANNOT_BE_NULL = "SEX_CANNOT_BE_NULL";
    public static final String IDINUSE = "idInUse";
    public static final String LASTMODIFYUSER = "lastModifyUser";
    public static final String GHOSTUSERLIST = "ghostUserList";
    public static final String DEVICETYPE = "deviceType";
    public static final String ANDROID = "Android";
    public static final String IOS = "IOS";
    public static final String MESSAGE_INFO = "MESSAGE_INFO";//跳转到消息中心
    public static final String CHANNELID = "channelId";
    public static final String PUSHFLAG = "pushFlag";
    public static final String POST = "POST";
    public static final String REALNAME = "realName";
    public static final String CODEPH = "codePh";
    public static final String USERPH = "userPh";
    public static final String COMMAND = "command";
    public static final String ISANCHOR = "isAnchor";
    public static final String REALANCHOR = "realAnchor";
    public static final String REJECTRECORD = "rejectRecord";
    public static final String RMANFLG = "rmAnFlg";
    public static final String FACERECHARGE = "faceRecharge";
    public static final String FACEEGG = "faceEgg";
    public static final String CASH = "cash";
    public static final String GIFTNAME = "giftName";
    public static final String GIFTNUM = "giftNum";
    public static final String GIFTPRICE = "giftPrice";
    public static final String DEFAULT = "default";
    public static final String SYSTEM_INFO = "SYSTEM_INFO";
    public static final String TOKENLOGIN = "tokenLogin";
    public static final String OUID = "oUid";
    public static final String RESREPLY = "resReplay";
    public static final String RESSTORY = "resStory";
    public static final String UIDTOID = "uIdToId";
    public static final String IDTOUID = "IdToUId";
    public static final String PREVIEWURL = "previewUrl";
    public static final String LAYOUTS = "layouts";
    public static final String IMG_LIMIT_OVER = "IMG_LIMIT_OVER";
    public static final String PERMISSION = "permission";
    public static final String ALERT = "alert";
    public static final String SOUND = "sound";
    public static final String APS = "aps";
    public static final String TLSCHANNELID = "TLSChnlId";
    public static final String AHLIST = "ahList";
    public static final String ISSIGNEDANCHOR = "isSignedAnchor";//是否为签约主播
    public static final long SHIT = 1000000000L;
    public static final String LIVESET_API = "Live_Channel_SetStatus";
    public static final String SIGNATURE_ERROR = "SIGNATURE_ERROR";
    public static final String TLSM3U8 = "TLSm3u8";//
    public static final String SYSTEMMSGTITLE = "系统消息";
    public static final String LIVEAHTHTITLE = "主播认证审核";
    public static final String SCORE_REPEAT = "SCORE_REPEAT";
    public static final String AH = "ah";
    public static final String ANFANS = "anFans";
    public static final String MEALTOTAL = "mealTotal";
    public static final String AHINDEXLIST = "ahIndexList";
    public static final String ACTIVENAME = "activeName";
    public static final String CID = "cId";
    public static final String RECOMMENDAH_NOT_OVER_FOUR = "RECOMMENDAH_NOT_OVER_FOUR";
    public static final String REFUNDALERT = "refundAlert";
    public static final String DISHHANDLERALERT = "dishHandlerAlert";
    public static final String APPLY = "apply";
    public static final String ANCHOR = "anchor";
    public static final String ANCHORAPPLY = "anchorApply";
    public static final String TEN = "10";
    public static final String TOTALMONEY = "totalMoney";
    public static final String REFUND = "refund";
    public static final String ANCHOR_APPLY_TREATED = "ANCHOR_APPLY_TREATED";
    public static final String CHANNELIDTOUID = "channelIdTouId";
    public static final String USERSIG = "USERSIG";
    public static final String IDENTIFIER = "IDENTIFIER";
    public static final String SDKAPPID = "SDKAPPID";
    public static final String GROUPID = "GroupId";
    public static final String ACTION_REPEAT = "ACTION_REPEAT";
    public static final String REJECTREASON = "rejectReason";//驳回原因
    public static final String BUSINESS = "business";
    public static final String AHINDEXVIDEO = "ahIndexVideo";
    public static final String ANPH = "anph";
    public static final String WATCHING = "watching";
    public static final String IFLIVE = "ifLive";//0可正常直播 1不可正常直播
    public static final String CONTENT = "Content";
    public static final String CHANNELIDS = "channelIds";
    public static final String ACTIONSTATUS = "ActionStatus";
    public static final String DISHMSG = "dishMsg";
    public static final String ORDERREFUND = "orderRefund";
    public static final String REFUNDCHECK = "refundCheck";

    public static final String GROUPINFOURL = "https://console.tim.qq.com/v4/group_open_http_svc/get_group_member_info?usersig=USERSIG&apn=1&identifier=IDENTIFIER&sdkappid=SDKAPPID&contenttype=json";
    public static final String GROUPMSG_URL = "https://console.tim.qq.com/v4/group_open_http_svc/send_group_system_notification?usersig=USERSIG&identifier=IDENTIFIER&sdkappid=SDKAPPID&random=99999999&contenttype=json";
    public static final String ANCASH = "anCash";
    public static final String UNREADMSG = "unreadMsg";
    public static final String CHANNELS = "channels";
    public static final String TIMESTAMPTOID = "timestampToId";
    public static final String MESSAGE = "message";


    /**
     * 运营端无用参数
     */
//    public static final String LOGOUT = "logOut";
//    public static final String LOGOUT_FAILED = "LOGOUT_FAILED";/**/
//    public static final String NP_ = "06";
//    public static final String PATH_ = "07";
//    public static final String FDK_ = "08";
//    public static final String IDCARD_ = "09";
//    public static final String NPP_ = "10";
//    public static final String LOC_ = "12";
//    public static final String ARE_ = "13";
//    public static final String CIR_ = "14";
//    public static final String CLA_ = "15";
//    public static final String CLB_ = "16";
//    public static final String SORT_ = "17";
//    public static final String KW_ = "18";
//    public static final String STAT_ = "21";
//    public static final String LAYOUTID_ = "22";
//    public static final String AMOUNT_ = "30";
//    public static final String TYPEDETAIL_ = "31";
//    public static final String REFUNDREA_ = "32";
//    public static final String LIKE_ = "36";
//    public static final String FIREID_ = "41";
//    public static final String PAYSTAT_ = "42";
//    public static final String CHID_ = "43";
//    public static final String GIFT_ = "44";
//    public static final String CODE_ = "46";
//    public static final String RESREPLY_ = "50";
//    public static final String REQSOURCE_ = "51";
//    public static final String SCATEGORY_ = "86";
//    public static final String SECONDLEVEL_1 = "65";
//    public static final String SECONDLEVEL_2 = "66";
//    public static final String RECHARGEMONEY_ = "71";
//    public static final String CONTROLNO_ = "78";
//    public static final String APPVERSION_ = "84";//APP版本号
//    public static final String PAYTYPE_ = "27";
//    public static final String PAYAMOUNT_ = "28";
//    public static final String LUID_ = "34";
//    public static final String FACEID_ = "38";
//    public static final String CLOID_ = "39";

    /**
     * 通过pubset或者offset以及事务seq，获取当前记录位置
     *
     * @param puboffset
     * @param seq
     * @return
     */
    public static long puboffsetAndSeq(long puboffset, int seq) {
        return puboffset * 100000 + seq;
    }

}
