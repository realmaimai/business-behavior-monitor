package com.maimai.infrastructure.dao;

import com.maimai.infrastructure.po.MonitorDataMap;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 监控数据地图配置(MonitorDataMap) table DAO
 *
 * @author maimai
 * @since 2024-07-08 16:34:44
 */
@Mapper
public interface IMonitorDataMapDao {

    /**
     * Retrieves a single data entry by ID
     *
     * @param id The primary key used for querying
     * @return The instance object found by the specified ID
     */
    MonitorDataMap queryById(Long id);

    /**
     * Retrieves specified rows of data based on the given conditions
     *
     * @param monitorDataMap The query criteria
     * @param pageable         The pagination object
     * @return A list of objects matching the criteria within the specified pagination
     */
    List<MonitorDataMap> queryAllByLimit(MonitorDataMap monitorDataMap, @Param("pageable") Pageable pageable);

    /**
     * Count the total number of rows
     *
     * @param monitorDataMap The query criteria
     * @return The total number of rows
     */
    long count(MonitorDataMap monitorDataMap);

    /**
     * Insert a new data instance
     *
     * @param monitorDataMap The instance object to insert
     * @return The number of rows affected by the insertion
     */
    int insert(MonitorDataMap monitorDataMap);

    /**
     * Batch insert data using MyBatis native foreach method
     *
     * @param entities List<MonitorDataMap> instance objects to insert
     * @return The number of rows affected by the batch insertion
     */
    int insertBatch(@Param("entities") List<MonitorDataMap> entities);

    /**
     * Batch insert or update data by primary key using MyBatis native foreach method
     *
     * @param entities List<MonitorDataMap> instance objects to insert or update
     * @return The number of rows affected by the batch insertion or update
     * @throws org.springframework.jdbc.BadSqlGrammarException Throws an exception if the input list is empty, resulting in an SQL syntax error
     */
    int insertOrUpdateBatch(@Param("entities") List<MonitorDataMap> entities);

    /**
     * Update existing data
     *
     * @param monitorDataMap The instance object containing updated data
     * @return The number of rows affected by the update operation
     */
    int update(MonitorDataMap monitorDataMap);

    /**
     * Delete data by primary key
     *
     * @param id The primary key value
     * @return The number of rows affected by the deletion
     */
    int deleteById(Long id);

}

