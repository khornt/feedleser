package com.horntvedt.camel.vgleser.config;

public enum RouteEndepunkter {

    VG_LESER_KONSUMENT("https://www.vg.no/rss/feed/?categories=&keywords=&limit=100&format=atom","Les atom feed fra VG");


    private final String uri;
    private final String id;

    RouteEndepunkter(String uri, String id) {

        this.uri = uri;
        this.id = id;

    }

    public String uri() {

        return uri;

    }

    public String id() {

        return id;

    }

}
