package com.kimbaro.www.ai_llm_module.config.init

import com.kimbaro.www.ai_llm_module.domains.HELLORING_AI_TEXT
import com.kimbaro.www.ai_llm_module.dto.GeminiThreadData
import jakarta.annotation.PostConstruct
import kotlinx.coroutines.*
import lombok.extern.slf4j.Slf4j
import org.slf4j.LoggerFactory
import org.springframework.context.ApplicationContext
import org.springframework.stereotype.Component
import java.util.concurrent.*

@Component
@Slf4j
class ThreadPoolGroups(private val applicationContext: ApplicationContext) {

    private val sessionQueue = ConcurrentLinkedQueue<GeminiThreadData>();
    private val log = LoggerFactory.getLogger(ThreadPoolGroups::class.java)
    private val executorService: ThreadPoolExecutor = ThreadPoolExecutor(
        5,  // core pool size
        10, // maximum pool size
        60L, TimeUnit.SECONDS, // keep alive time for idle threads
        LinkedBlockingQueue(50), // 큐 크기 설정 (50)
        ThreadPoolExecutor.CallerRunsPolicy() // 작업이 거부될 경우 호출자 실행
    )


    @PostConstruct
    private fun startProcessingQueue() {
        log.info("Starting Thread Groups")
        CoroutineScope(Dispatchers.Default).launch {
            while (isActive) {
                if (sessionQueue.isNotEmpty()) {
                    while (sessionQueue.isNotEmpty()) {
                        try {
                            executorService.submit {
                                val batch: GeminiThreadData = dequeue()
                                log.info("execute : ${batch}")
                                val obj = applicationContext.getBean("HELLORING_AI_TEXT") as HELLORING_AI_TEXT
                                obj.execute(batch)
                            }
                        } catch (e: Exception) {
                            log.error("Error submitting task to thread pool: ${e.message}")
                            break
                        }
                    }
                }
                delay(1000)
            }
        }
    }

    fun enqueue(obj: GeminiThreadData) {
        log.info("ENQUEUED SESSION : ${obj.session.id}")
        sessionQueue.offer(obj)
    }

    private fun dequeue(): GeminiThreadData {
        return sessionQueue.poll()
    }
}
