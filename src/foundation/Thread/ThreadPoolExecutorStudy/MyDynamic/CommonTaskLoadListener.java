package foundation.Thread.ThreadPoolExecutorStudy.MyDynamic;

import lombok.extern.slf4j.Slf4j;
import org.quartz.impl.StdScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.CollectionUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

/**
 * ServletContextListener 监听 Web 应用的生命周期
 * 当Servlet 容器启动或终止Web 应用时，会触发ServletContextEvent 事件，该事件由 ServletContextListener 来处理。
 */
@Slf4j
public class CommonTaskLoadListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
//        CommonTaskManageThread commonTaskManageThread = AppContext.getBean(CommonTaskManageThread.class);
//        commonTaskManageThread.setName("visitor_commonTaskManageThread");
//        commonTaskManageThread.setDaemon(true);
//        commonTaskManageThread.start();
//
//        OneMinuteTaskManageThread oneMinuteTaskManageThread = AppContext.getBean(OneMinuteTaskManageThread.class);
//        oneMinuteTaskManageThread.setName("visitor_oneMinuteTaskManageThread");
//        oneMinuteTaskManageThread.setDaemon(true);
//        oneMinuteTaskManageThread.start();
//
//        FiveSecondTaskServiceThread fiveSecondTaskServiceThread = AppContext.getBean(FiveSecondTaskServiceThread.class);
//        fiveSecondTaskServiceThread.setName("visitor_fiveSecondTaskServiceThread");
//        fiveSecondTaskServiceThread.setDaemon(true);
//        fiveSecondTaskServiceThread.start();
        
        if(log.isInfoEnabled()){
//            log.info(HikLog.toLog("start visitor_oneMinuteTaskManageThread"));
        }

		// TODO 初始化线程池
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
//    	try {
//        	//任务线程关闭
//            CommonTaskManageThread commonTaskManageThread = AppContext.getBean(CommonTaskManageThread.class);
//            if(commonTaskManageThread!=null){
//                commonTaskManageThread.cancel();
//                log.error(HikLog.toLog(StringOrNumericUtils.toHexString(ErrorCodeConstant.OPERATE_FAIL), "cancel visitor_commonTaskManageThread success"));
//            }
//		} catch (Exception e) {
//			log.error(HikLog.toLog(StringOrNumericUtils.toHexString(ErrorCodeConstant.OPERATE_FAIL), "cancel visitor_commonTaskManageThread error"),e);
//		}
//
//    	try {
//        	//任务线程关闭
//    		OneMinuteTaskManageThread oneMinuteTaskManageThread = AppContext.getBean(OneMinuteTaskManageThread.class);
//            if(oneMinuteTaskManageThread!=null){
//                oneMinuteTaskManageThread.cancel();
//                log.error(HikLog.toLog(StringOrNumericUtils.toHexString(ErrorCodeConstant.OPERATE_FAIL), "cancel visitor_commonTaskManageThread success"));
//            }
//		} catch (Exception e) {
//			log.error(HikLog.toLog(StringOrNumericUtils.toHexString(ErrorCodeConstant.OPERATE_FAIL), "cancel visitor_commonTaskManageThread error"),e);
//		}
//
//    	try {
//        	//任务线程关闭
//    		FiveSecondTaskServiceThread fiveSecondTaskServiceThread = AppContext.getBean(FiveSecondTaskServiceThread.class);
//            if(fiveSecondTaskServiceThread!=null){
//            	fiveSecondTaskServiceThread.cancel();
//                log.error(HikLog.toLog(StringOrNumericUtils.toHexString(ErrorCodeConstant.OPERATE_FAIL), "cancel visitor_fiveSecondTaskServiceThread success"));
//            }
//		} catch (Exception e) {
//			log.error(HikLog.toLog(StringOrNumericUtils.toHexString(ErrorCodeConstant.OPERATE_FAIL), "cancel visitor_fiveSecondTaskServiceThread error"),e);
//		}
//
//
//
//        try {
//        	 //关闭MQ的监听
//            VisitorMessageReceiverThread visitorMessageReceiverThread = AppContext.getBean(VisitorMessageReceiverThread.class);
//            if(visitorMessageReceiverThread!=null){
//            	visitorMessageReceiverThread.cancel();
//                log.error(HikLog.toLog(StringOrNumericUtils.toHexString(ErrorCodeConstant.OPERATE_FAIL), "cancel visitorMessageReceiverThread success"));
//            }
//		} catch (Exception e) {
//			log.error(HikLog.toLog(StringOrNumericUtils.toHexString(ErrorCodeConstant.OPERATE_FAIL), "stop visitorMessageReceiverThread error"+e.getMessage()),e);
//		}
//        try {
//            //关闭事件接收处理
//            EventMessageReciverThread eventMessageReciverThread = (EventMessageReciverThread)AppContext.getBean("eventMessageReciverThread");
//            if(eventMessageReciverThread!=null){
//                eventMessageReciverThread.cancel();
//                log.error(HikLog.toLog(StringOrNumericUtils.toHexString(ErrorCodeConstant.OPERATE_FAIL), "cancel eventMessageReciverThread success"));
//            }
//        } catch (Exception e) {
//            log.error(HikLog.toLog(StringOrNumericUtils.toHexString(ErrorCodeConstant.OPERATE_FAIL), "cancel eventMessageReciverThread error"+e.getMessage()),e);
//        }
//
//        try {
//            //关闭工作流组件流程定义事件接收处理
//            WorkFlowMessageReciverThread workFlowMessageReciverThread = (WorkFlowMessageReciverThread)AppContext.getBean("workFlowMessageReciverThread");
//            if(workFlowMessageReciverThread!=null){
//                workFlowMessageReciverThread.cancel();
//                log.error(HikLog.toLog(StringOrNumericUtils.toHexString(ErrorCodeConstant.OPERATE_FAIL), "cancel workFlowMessageReciverThread success"));
//            }
//        } catch (Exception e) {
//            log.error(HikLog.toLog(StringOrNumericUtils.toHexString(ErrorCodeConstant.OPERATE_FAIL), "cancel workFlowMessageReciverThread error"+e.getMessage()),e);
//        }
//
//        try {
//            //关闭线程池
//            ThreadPoolTaskExecutor taskExecutor = AppContext.getBean("taskExecutor");
//            if(taskExecutor!=null){
//                int activeThreadCount = taskExecutor.getActiveCount();
//                taskExecutor.shutdown();
//                log.error(HikLog.toLog(StringOrNumericUtils.toHexString(ErrorCodeConstant.OPERATE_FAIL), "stop visitor_thread_pool_,continue executing thread count is " + activeThreadCount));
//            }
//		} catch (Exception e) {
//			log.error(HikLog.toLog(StringOrNumericUtils.toHexString(ErrorCodeConstant.OPERATE_FAIL), "cancel ThreadPoolTaskExecutor error"+e.getMessage()),e);
//		}
        



		// TODO 获取 线程池管理map，取出所有线程池，逐个关闭
		try {
			MyThreadPoolExecutorManage myThreadPoolExecutorManage = MyThreadPoolExecutorManage.getInstance();
			if (null != myThreadPoolExecutorManage && !CollectionUtils.isEmpty(myThreadPoolExecutorManage.getThreadPoolExecutorMap())) {
				for(MyThreadPoolExecutor executor : myThreadPoolExecutorManage.getThreadPoolExecutorMap().values()) {
					if (null != executor) {
						log.info(executor.getPoolName() + "线程池 正在关闭");
						executor.shutdown();
					}
				}
			}
			myThreadPoolExecutorManage = null;
		} catch (Exception e) {
			log.error(e.getMessage());
		}
        


    }
}