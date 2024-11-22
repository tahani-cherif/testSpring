package tn.esprit.test.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Component
@Aspect
@Slf4j
public class loggingAspect {
    @AfterThrowing("execution(* tn.esprit.test.Service..ajouterTicketsEtAffecterenementEtInternaute(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("le nombre de places restantes depasse le nombre demandes");
    }
}