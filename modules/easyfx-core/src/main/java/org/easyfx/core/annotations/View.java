package org.easyfx.core.annotations;

import io.micronaut.core.annotation.Introspected;
import jakarta.inject.Singleton;
import org.easyfx.core.ViewType;

@Introspected
@Singleton
public @interface View {
    String value();
    ViewType type() default ViewType.MARKUP;
}
