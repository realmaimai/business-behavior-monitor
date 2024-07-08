package com.maimai.infrastructure.dao;

import com.maimai.infrastructure.po.MonitorDataMapNodeLink;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 监控数据地图节点链路配置(MonitorDataMapNodeLink) table DAO
 *
 * @author maimai
 * @since 2024-07-08 16:34:58
 */
@Mapper
public interface IMonitorDataMapNodeLinkDao {

    /**
     * Retrieves a single data entry by ID
     *
     * @param id The primary key used for querying
     * @return The instance object found by the specified ID
     */
    MonitorDataMapNodeLink queryById(Long id);

    /**
     * Retrieves specified rows of data based on the given conditions
     *
     * @param monitorDataMapNodeLink The query criteria
     * @param pageable               The pagination object
     * @return A list of objects matching the criteria within the specified pagination
     */
    List<MonitorDataMapNodeLink> queryAllByLimit(MonitorDataMapNodeLink monitorDataMapNodeLink, @Param("pageable") Pageable pageable);

    /**
     * Count the total number of rows
     *
     * @param monitorDataMapNodeLink The query criteria
     * @return The total number of rows
     */
    long count(MonitorDataMapNodeLink monitorDataMapNodeLink);

    /**
     * Insert a new data instance
     *
     * @param monitorDataMapNodeLink The instance object to insert
     * @return The number of rows affected by the insertion
     */
    int insert(MonitorDataMapNodeLink monitorDataMapNodeLink);

    /**
     * Batch insert data using MyBatis native foreach method
     *
     * @param entities List<MonitorDataMapNodeLink> instance objects to insert
     * @return The number of rows affected by the batch insertion
     */
    int insertBatch(@Param("entities") List<MonitorDataMapNodeLink> entities);

    /**
     * Batch insert or update data by primary key using MyBatis native foreach method
     *
     * @param entities List<MonitorDataMapNodeLink> instance objects to insert or update
     * @return The number of rows affected by the batch insertion or update
     * @throws org.springframework.jdbc.BadSqlGrammarException Throws an exception if the input list is empty, resulting in an SQL syntax error
     */
    int insertOrUpdateBatch(@Param("entities") List<MonitorDataMapNodeLink> entities);

    /**
     * Update existing data
     *
     * @param monitorDataMapNodeLink The instance object containing updated data
     * @return The number of rows affected by the update operation
     */
    int update(MonitorDataMapNodeLink monitorDataMapNodeLink);

    /**
     * Delete data by primary key
     *
     * @param id The primary key value
     * @return The number of rows affected by the deletion
     */
    int deleteById(Long id);

}

