package com.example.logexporter

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.dao.DataAccessResourceFailureException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate

@Service
class DbService @Autowired constructor(private val jdbcTemplate: JdbcTemplate) {
    private val logger = LoggerFactory.getLogger(DbService::class.java)

    fun queryDb(): String {
        logger.info("DbService: Executing invalid SQL query to simulate JPA exception.")
        // Attempt to query a non-existent table
        jdbcTemplate.queryForObject("SELECT * FROM non_existent_table", String::class.java)
        return "Should not reach here"
    }
}
