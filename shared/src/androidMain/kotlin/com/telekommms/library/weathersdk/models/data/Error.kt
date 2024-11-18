package com.telekommms.library.weathersdk.models.data

enum class Error(value: Int) {
    unknown(1),

    no_internet_or_other(2),

    invalid_body_parameters(3),

    invalid_query_parameters(4),

    missing_required_body_parameters(5),

    missing_required_query_parameters(6),

    rule_violation(7),

    missing_required_header_parameters(8),

    invalid_path_parameters(9),

    unauthorized(10),

    too_many_requests(11),

    access_denied(12),

    account_limit(13),

    forbidden_action(14),

    not_found(15),

    unexpected(16),

    unavailable(17);
}