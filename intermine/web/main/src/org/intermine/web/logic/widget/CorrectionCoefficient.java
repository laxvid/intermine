package org.intermine.web.logic.widget;

/*
 * Copyright (C) 2002-2013 FlyMine
 *
 * This code may be freely distributed and modified under the
 * terms of the GNU Lesser General Public Licence.  This should
 * be distributed with the code.  See the LICENSE file for more
 * information or http://www.gnu.org/copyleft/lesser.html.
 *
 */

import java.math.BigDecimal;
import java.util.Map;

import org.intermine.objectstore.query.Query;
import org.intermine.objectstore.query.QueryClass;
import org.intermine.objectstore.query.QueryField;

/**
 * An Interface which defines when/how a correction coefficient can be applied
 * to the results obtained by a enrichment widget
 * @author Daniela Butano
 *
 */
public interface CorrectionCoefficient
{
    /**
     * Return true if the correction coefficient is applicable
     * @return true/false
     */
    boolean isApplicable();

    /**
     * Return true if the correction coefficient is selected
     * @return true/false
     */
    boolean isSelected(String correctionCoefficientInput);

    /**
     * Update the query, given in input, with the field associated to the correction coefficient
     * and return it 
     * @return the query field
     */
    QueryField updateQueryWithCorrectionCoefficient(Query query, QueryClass qc);

    /**
     * Update the annotated population query given in input using the queryfield
     * specific for the correction
     * @param q the annotated population query
     * @param subQ the subquery used in the population query
     * @param qf the query field specific for the correction
     */
    void updatePopulationQuery(Query q, Query subQ, QueryField qf);

    /**
     * Apply the correction coefficient to the pValuesTerm given in input
     * @param pValuesPerTerm
     * @param population
     * @param annotatedPopulationInfo
     */
    void apply(Map<String, BigDecimal> pValuesPerTerm,
            PopulationInfo population, Map<String, PopulationInfo> annotatedPopulationInfo);

    /**
     * Return the key value pairs to put in the webservice result
     * @return true/false
     */
    Map<String, Map<String, Object>> getOutputInfo(String correctionCoefficientInput);
}
