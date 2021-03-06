package com.king2.commons.mapper;

import com.king2.commons.pojo.King2SensitivityLexicon;
import com.king2.commons.pojo.King2SensitivityLexiconExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface King2SensitivityLexiconMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table king2_sensitivity_lexicon
     *
     * @mbggenerated Sat Aug 17 09:38:13 CST 2019
     */
    int countByExample(King2SensitivityLexiconExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table king2_sensitivity_lexicon
     *
     * @mbggenerated Sat Aug 17 09:38:13 CST 2019
     */
    int deleteByExample(King2SensitivityLexiconExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table king2_sensitivity_lexicon
     *
     * @mbggenerated Sat Aug 17 09:38:13 CST 2019
     */
    int deleteByPrimaryKey(Integer lexiconId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table king2_sensitivity_lexicon
     *
     * @mbggenerated Sat Aug 17 09:38:13 CST 2019
     */
    int insert(King2SensitivityLexicon record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table king2_sensitivity_lexicon
     *
     * @mbggenerated Sat Aug 17 09:38:13 CST 2019
     */
    int insertSelective(King2SensitivityLexicon record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table king2_sensitivity_lexicon
     *
     * @mbggenerated Sat Aug 17 09:38:13 CST 2019
     */
    List<King2SensitivityLexicon> selectByExampleWithBLOBs(King2SensitivityLexiconExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table king2_sensitivity_lexicon
     *
     * @mbggenerated Sat Aug 17 09:38:13 CST 2019
     */
    List<King2SensitivityLexicon> selectByExample(King2SensitivityLexiconExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table king2_sensitivity_lexicon
     *
     * @mbggenerated Sat Aug 17 09:38:13 CST 2019
     */
    King2SensitivityLexicon selectByPrimaryKey(Integer lexiconId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table king2_sensitivity_lexicon
     *
     * @mbggenerated Sat Aug 17 09:38:13 CST 2019
     */
    int updateByExampleSelective(@Param("record") King2SensitivityLexicon record, @Param("example") King2SensitivityLexiconExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table king2_sensitivity_lexicon
     *
     * @mbggenerated Sat Aug 17 09:38:13 CST 2019
     */
    int updateByExampleWithBLOBs(@Param("record") King2SensitivityLexicon record, @Param("example") King2SensitivityLexiconExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table king2_sensitivity_lexicon
     *
     * @mbggenerated Sat Aug 17 09:38:13 CST 2019
     */
    int updateByExample(@Param("record") King2SensitivityLexicon record, @Param("example") King2SensitivityLexiconExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table king2_sensitivity_lexicon
     *
     * @mbggenerated Sat Aug 17 09:38:13 CST 2019
     */
    int updateByPrimaryKeySelective(King2SensitivityLexicon record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table king2_sensitivity_lexicon
     *
     * @mbggenerated Sat Aug 17 09:38:13 CST 2019
     */
    int updateByPrimaryKeyWithBLOBs(King2SensitivityLexicon record);
}