input{
    file{
        type => "syslog"
        path => ""
    }
}

output{
    if [type] => "syslog"{
        elasticsearch{
            host => ["localhost:9200"]
            index => "syslog-%{+YYYY.MM.dd}"
        }
    }

    stdout {codec => rubydebug}
}

