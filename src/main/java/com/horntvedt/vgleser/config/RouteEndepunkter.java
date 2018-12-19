package com.horntvedt.vgleser.config;

public enum RouteEndepunkter {

    VG_LESER_KONSUMENT("http://www.vg.no/rss/feed/?categories=&keywords=&limit=100&format=atom","Les atom feed fra VG"),
    LESER("timer://mintimer?FixedRate=true&period=60000", "Feed Route");


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
