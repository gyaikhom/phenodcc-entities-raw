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
@Table(name = "LINE", catalog = "phenodcc_raw", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Line.findAll", query = "SELECT l FROM Line l"),
    @NamedQuery(name = "Line.findByHjid", query = "SELECT l FROM Line l WHERE l.hjid = :hjid"),
    @NamedQuery(name = "Line.findByColonyid", query = "SELECT l FROM Line l WHERE l.colonyid = :colonyid")})
public class Line implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Long hjid;
    @Column(length = 255)
    private String colonyid;
    @Basic(optional = true)
    @Column(nullable = true, length = 255)
    private String sequenceid;
    @JoinColumn(name = "LINE_CENTREPROCEDURE_HJID", referencedColumnName = "HJID")
    @ManyToOne(cascade = CascadeType.ALL)
    private Centreprocedure lineCentreprocedureHjid;
    @JoinColumn(name = "PROCEDURE__LINE_HJID", referencedColumnName = "HJID")
    @ManyToOne(cascade = CascadeType.ALL)
    private ProcedureFromRaw procedureLineHjid;

    public Line() {
    }

    public Line(Long hjid) {
        this.hjid = hjid;
    }

    public Long getHjid() {
        return hjid;
    }

    public void setHjid(Long hjid) {
        this.hjid = hjid;
    }

    public String getColonyid() {
        return colonyid;
    }

    public void setColonyid(String colonyid) {
        this.colonyid = colonyid;
    }

    public String getSequenceid() {
        return sequenceid;
    }

    public void setSequenceid(String sequenceid) {
        this.sequenceid = sequenceid;
    }

    public Centreprocedure getLineCentreprocedureHjid() {
        return lineCentreprocedureHjid;
    }

    public void setLineCentreprocedureHjid(Centreprocedure lineCentreprocedureHjid) {
        this.lineCentreprocedureHjid = lineCentreprocedureHjid;
    }

    public ProcedureFromRaw getProcedureLineHjid() {
        return procedureLineHjid;
    }

    public void setProcedureLineHjid(ProcedureFromRaw procedureLineHjid) {
        this.procedureLineHjid = procedureLineHjid;
    }
}
