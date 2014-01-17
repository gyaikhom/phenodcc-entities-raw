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
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Gagarine Yaikhom <g.yaikhom@har.mrc.ac.uk>
 */
@Entity
@Table(name = "SUBMISSION", catalog = "phenodcc_raw", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Submission.findAll", query = "SELECT s FROM Submission s"),
    @NamedQuery(name = "Submission.findByHjid", query = "SELECT s FROM Submission s WHERE s.hjid = :hjid"),
    @NamedQuery(name = "Submission.findBySubmissiondate", query = "SELECT s FROM Submission s WHERE s.submissiondate = :submissiondate"),
    @NamedQuery(name = "Submission.findByTrackerid", query = "SELECT s FROM Submission s WHERE s.trackerid = :trackerid")})
public class Submission implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Long hjid;
    @Temporal(TemporalType.TIMESTAMP)
    private Date submissiondate;
    private BigInteger trackerid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "centreprocedureSubmissionH0")
    private Collection<Centreprocedure> centreprocedureCollection;
    @JoinColumn(name = "SUBMISSION_SUBMISSIONSET_HJID", referencedColumnName = "HJID")
    @ManyToOne(cascade = CascadeType.ALL)
    private Submissionset submissionSubmissionsetHjid;

    public Submission() {
    }

    public Submission(Long hjid) {
        this.hjid = hjid;
    }

    public Long getHjid() {
        return hjid;
    }

    public void setHjid(Long hjid) {
        this.hjid = hjid;
    }

    public Date getSubmissiondate() {
        return submissiondate;
    }

    public void setSubmissiondate(Date submissiondate) {
        this.submissiondate = submissiondate;
    }

    public BigInteger getTrackerid() {
        return trackerid;
    }

    public void setTrackerid(BigInteger trackerid) {
        this.trackerid = trackerid;
    }

    @XmlTransient
    public Collection<Centreprocedure> getCentreprocedureCollection() {
        return centreprocedureCollection;
    }

    public void setCentreprocedureCollection(Collection<Centreprocedure> centreprocedureCollection) {
        this.centreprocedureCollection = centreprocedureCollection;
    }

    public Submissionset getSubmissionSubmissionsetHjid() {
        return submissionSubmissionsetHjid;
    }

    public void setSubmissionSubmissionsetHjid(Submissionset submissionSubmissionsetHjid) {
        this.submissionSubmissionsetHjid = submissionSubmissionsetHjid;
    }
}
