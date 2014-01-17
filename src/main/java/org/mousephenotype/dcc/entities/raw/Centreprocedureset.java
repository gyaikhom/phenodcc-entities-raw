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
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Gagarine Yaikhom <g.yaikhom@har.mrc.ac.uk>
 */
@Entity
@Table(name = "CENTREPROCEDURESET", catalog = "phenodcc_raw", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Centreprocedureset.findAll", query = "SELECT c FROM Centreprocedureset c"),
    @NamedQuery(name = "Centreprocedureset.findByHjid", query = "SELECT c FROM Centreprocedureset c WHERE c.hjid = :hjid")})
public class Centreprocedureset implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Long hjid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "centreCentreproceduresetHj0")
    private Collection<Centreprocedure> centreprocedureCollection;

    public Centreprocedureset() {
    }

    public Centreprocedureset(Long hjid) {
        this.hjid = hjid;
    }

    public Long getHjid() {
        return hjid;
    }

    public void setHjid(Long hjid) {
        this.hjid = hjid;
    }

    @XmlTransient
    public Collection<Centreprocedure> getCentreprocedureCollection() {
        return centreprocedureCollection;
    }

    public void setCentreprocedureCollection(Collection<Centreprocedure> centreprocedureCollection) {
        this.centreprocedureCollection = centreprocedureCollection;
    }
}
