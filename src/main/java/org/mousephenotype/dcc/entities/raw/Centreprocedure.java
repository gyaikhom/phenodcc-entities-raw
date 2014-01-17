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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "CENTREPROCEDURE", catalog = "phenodcc_raw", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Centreprocedure.findAll", query = "SELECT c FROM Centreprocedure c"),
    @NamedQuery(name = "Centreprocedure.findByHjid", query = "SELECT c FROM Centreprocedure c WHERE c.hjid = :hjid"),
    @NamedQuery(name = "Centreprocedure.findByCentreid", query = "SELECT c FROM Centreprocedure c WHERE c.centreid = :centreid"),
    @NamedQuery(name = "Centreprocedure.findByPipeline", query = "SELECT c FROM Centreprocedure c WHERE c.pipeline = :pipeline"),
    @NamedQuery(name = "Centreprocedure.findByProject", query = "SELECT c FROM Centreprocedure c WHERE c.project = :project")})
public class Centreprocedure implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Long hjid;
    @Column(length = 255)
    private String centreid;
    @Column(length = 255)
    private String pipeline;
    @Column(length = 255)
    private String project;
    @JoinColumn(name = "CENTRE_CENTREPROCEDURESET_HJ_0", referencedColumnName = "HJID")
    @ManyToOne(cascade = CascadeType.ALL)
    private Centreprocedureset centreCentreproceduresetHj0;
    @JoinColumn(name = "CENTREPROCEDURE_SUBMISSION_H_0", referencedColumnName = "HJID")
    @ManyToOne(cascade = CascadeType.ALL)
    private Submission centreprocedureSubmissionH0;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lineCentreprocedureHjid")
    private Collection<Line> lineCollection;

    public Centreprocedure() {
    }

    public Centreprocedure(Long hjid) {
        this.hjid = hjid;
    }

    public Long getHjid() {
        return hjid;
    }

    public void setHjid(Long hjid) {
        this.hjid = hjid;
    }

    public String getCentreid() {
        return centreid;
    }

    public void setCentreid(String centreid) {
        this.centreid = centreid;
    }

    public String getPipeline() {
        return pipeline;
    }

    public void setPipeline(String pipeline) {
        this.pipeline = pipeline;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public Centreprocedureset getCentreCentreproceduresetHj0() {
        return centreCentreproceduresetHj0;
    }

    public void setCentreCentreproceduresetHj0(Centreprocedureset centreCentreproceduresetHj0) {
        this.centreCentreproceduresetHj0 = centreCentreproceduresetHj0;
    }

    public Submission getCentreprocedureSubmissionH0() {
        return centreprocedureSubmissionH0;
    }

    public void setCentreprocedureSubmissionH0(Submission centreprocedureSubmissionH0) {
        this.centreprocedureSubmissionH0 = centreprocedureSubmissionH0;
    }

    @XmlTransient
    public Collection<Line> getLineCollection() {
        return lineCollection;
    }

    public void setLineCollection(Collection<Line> lineCollection) {
        this.lineCollection = lineCollection;
    }
}
