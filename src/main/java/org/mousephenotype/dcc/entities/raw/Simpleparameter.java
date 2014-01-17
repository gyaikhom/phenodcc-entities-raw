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
@Table(name = "SIMPLEPARAMETER", catalog = "phenodcc_raw", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Simpleparameter.findAll", query = "SELECT s FROM Simpleparameter s"),
    @NamedQuery(name = "Simpleparameter.findByHjid", query = "SELECT s FROM Simpleparameter s WHERE s.hjid = :hjid"),
    @NamedQuery(name = "Simpleparameter.findByParameterid", query = "SELECT s FROM Simpleparameter s WHERE s.parameterid = :parameterid"),
    @NamedQuery(name = "Simpleparameter.findByParameterstatus", query = "SELECT s FROM Simpleparameter s WHERE s.parameterstatus = :parameterstatus"),
    @NamedQuery(name = "Simpleparameter.findBySequenceid", query = "SELECT s FROM Simpleparameter s WHERE s.sequenceid = :sequenceid"),
    @NamedQuery(name = "Simpleparameter.findByUnit", query = "SELECT s FROM Simpleparameter s WHERE s.unit = :unit"),
    @NamedQuery(name = "Simpleparameter.findByValue", query = "SELECT s FROM Simpleparameter s WHERE s.value = :value")})
public class Simpleparameter implements Serializable {

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
    @Column(name = "VALUE_", length = 1024)
    private String value;
    @JoinColumn(name = "SIMPLEPARAMETER_PROCEDURE__H_0", referencedColumnName = "HJID")
    @ManyToOne(cascade = CascadeType.ALL)
    private ProcedureFromRaw simpleparameterProcedureH0;

    public Simpleparameter() {
    }

    public Simpleparameter(Long hjid) {
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ProcedureFromRaw getSimpleparameterProcedureH0() {
        return simpleparameterProcedureH0;
    }

    public void setSimpleparameterProcedureH0(ProcedureFromRaw simpleparameterProcedureH0) {
        this.simpleparameterProcedureH0 = simpleparameterProcedureH0;
    }
}
