package com.maimai.infrastructure.dao;


import com.maimai.infrastructure.po.MonitorDataMapNodeField;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 监控数据地图节点字段配置(MonitorDataMapNodeField) table DAO
 *
 * @author maimai
 * @since 2024-07-08 16:34:55
 */
@Mapper
public interface IMonitorDataMapNodeFieldDao {

    /**
     * Retrieves a single data entry by ID
     *
     * @param id The primary key used for querying
     * @return The instance object found by the specified ID
     */
    MonitorDataMapNodeField queryById(Long id);

    /**
     * Retrieves specified rows of data based on the given conditions
     *
     * @param monitorDataMapNodeField The query criteria
     * @param pageable         The pagination object
     * @return A list of objects matching the criteria within the specified pagination
     */
    List<MonitorDataMapNodeField> queryAllByLimit(MonitorDataMapNodeField monitorDataMapNodeField, @Param("pageable") Pageable pageable);

    /**
     * Count the total number of rows
     *
     * @param monitorDataMapNodeField The query criteria
     * @return The total number of rows
     */
    long count(MonitorDataMapNodeField monitorDataMapNodeField);

    /**
     * Insert a new data instance
     *
     * @param monitorDataMapNodeField The instance object to insert
     * @return The number of rows affected by the insertion
     */
    int insert(MonitorDataMapNodeField monitorDataMapNodeField);

    /**
     * Batch insert data using MyBatis native foreach method
     *
     * @param entities List<MonitorDataMapNodeField> instance objects to insert
     * @return The number of rows affected by the batch insertion
     */
    int insertBatch(@Param("entities") List<MonitorDataMapNodeField> entities);

    /**
     * Batch insert or update data by primary key using MyBatis native foreach method
     *
     * @param entities List<MonitorDataMapNodeField> instance objects to insert or update
     * @return The number of rows affected by the batch insertion or update
     * @throws org.springframework.jdbc.BadSqlGrammarException Throws an exception if the input list is empty, resulting in an SQL syntax error
     */
    int insertOrUpdateBatch(@Param("entities") List<MonitorDataMapNodeField> entities);

    /**
     * Update existing data
     *
     * @param monitorDataMapNodeField The instance object containing updated data
     * @return The number of rows affected by the update operation
     */
    int update(MonitorDataMapNodeField monitorDataMapNodeField);

    /**
     * Delete data by primary key
     *
     * @param id The primary key value
     * @return The number of rows affected by the deletion
     */
    int deleteById(Long id);

}

