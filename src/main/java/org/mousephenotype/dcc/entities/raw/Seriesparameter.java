/*
 * Copyright 2013 Medical Research Council Harwell.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.mousephenotype.dcc.entities.raw;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gagarine Yaikhom <g.yaikhom@har.mrc.ac.uk>
 */
@Entity
@Table(name = "SERIESPARAMETER", catalog = "phenodcc_raw", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seriesparameter.findAll", query = "SELECT s FROM Seriesparameter s"),
    @NamedQuery(name = "Seriesparameter.findByHjid", query = "SELECT s FROM Seriesparameter s WHERE s.hjid = :hjid"),
    @NamedQuery(name = "Seriesparameter.findByParameterid", query = "SELECT s FROM Seriesparameter s WHERE s.parameterid = :parameterid"),
    @NamedQuery(name = "Seriesparameter.findByParameterstatus", query = "SELECT s FROM Seriesparameter s WHERE s.parameterstatus = :parameterstatus"),
    @NamedQuery(name = "Seriesparameter.findBySequenceid", query = "SELECT s FROM Seriesparameter s WHERE s.sequenceid = :sequenceid"),
    @NamedQuery(name = "Seriesparameter.findByUnit", query = "SELECT s FROM Seriesparameter s WHERE s.unit = :unit")})
public class Seriesparameter implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Long hjid;
    @Column(length = 255)
    private String parameterid;
    @Column(length = 255)
    private String parameterstatus;
    private BigInteger sequenceid;
    @Column(length = 255)
    private String unit;
    @JoinColumn(name = "SERIESPARAMETER_PROCEDURE__H_0", referencedColumnName = "HJID")
    @ManyToOne(cascade = CascadeType.ALL)
    private ProcedureFromRaw seriesparameterProcedureH0;

    public Seriesparameter() {
    }

    public Seriesparameter(Long hjid) {
        this.hjid = hjid;
    }

    public Long getHjid() {
        return hjid;
    }

    public void setHjid(Long hjid) {
        this.hjid = hjid;
    }

    public String getParameterid() {
        return parameterid;
    }

    public void setParameterid(String parameterid) {
        this.parameterid = parameterid;
    }

    public String getParameterstatus() {
        return parameterstatus;
    }

    public void setParameterstatus(String parameterstatus) {
        this.parameterstatus = parameterstatus;
    }

    public BigInteger getSequenceid() {
        return sequenceid;
    }

    public void setSequenceid(BigInteger sequenceid) {
        this.sequenceid = sequenceid;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public ProcedureFromRaw getSeriesparameterProcedureH0() {
        return seriesparameterProcedureH0;
    }

    public void setSeriesparameterProcedureH0(ProcedureFromRaw seriesparameterProcedureH0) {
        this.seriesparameterProcedureH0 = seriesparameterProcedureH0;
    }
}
