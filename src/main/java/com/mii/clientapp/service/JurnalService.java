package com.mii.clientapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mii.clientapp.model.Jurnal;

@Service
public class JurnalService {
        private RestTemplate restTemplate;

        @Value("${server.baseUrl}/jurnal")
        private String url;

        @Autowired
        public JurnalService(RestTemplate restTemplate) {
                this.restTemplate = restTemplate;
        }

        public List<Jurnal> getAll() {
                return restTemplate
                                .exchange(url, HttpMethod.GET, null,
                                                new ParameterizedTypeReference<List<Jurnal>>() {
                                                })
                                .getBody();
        }

        public List<Jurnal> getAllstatus() {
                return restTemplate
                                .exchange(url.concat("/status"), HttpMethod.GET, null,
                                                new ParameterizedTypeReference<List<Jurnal>>() {
                                                })
                                .getBody();
        }

        public List<Jurnal> getAlladdjurnal() {
                return restTemplate
                                .exchange(url.concat("/addjurnal"), HttpMethod.GET, null,
                                                new ParameterizedTypeReference<List<Jurnal>>() {
                                                })
                                .getBody();
        }

        public Jurnal getById(Long id) {
                return restTemplate
                                .exchange(url.concat("/" + id), HttpMethod.GET, null,
                                                new ParameterizedTypeReference<Jurnal>() {
                                                })
                                .getBody();
        }

        public Jurnal create(Jurnal jurnal) {
                return restTemplate
                                .exchange(url, HttpMethod.POST, new HttpEntity(jurnal),
                                                new ParameterizedTypeReference<Jurnal>() {
                                                })
                                .getBody();
        }

        public Jurnal update(Long id, Jurnal jurnal) {
                return restTemplate
                                .exchange(url.concat("/" + id), HttpMethod.PUT, new HttpEntity(jurnal),
                                                new ParameterizedTypeReference<Jurnal>() {
                                                })
                                .getBody();
        }

        public Jurnal delete(Long id) {
                return restTemplate
                                .exchange(url.concat("/" + id), HttpMethod.DELETE, null,
                                                new ParameterizedTypeReference<Jurnal>() {
                                                })
                                .getBody();
        }
}
