package com.github.dreamhead.moco.matcher;

import com.github.dreamhead.moco.Request;
import com.github.dreamhead.moco.RequestExtractor;
import com.github.dreamhead.moco.RequestMatcher;
import com.github.dreamhead.moco.resource.Resource;

public final class EqRequestMatcher<T> extends AbstractOperatorMatcher<T> {
    public EqRequestMatcher(final RequestExtractor<T> extractor, final Resource expected) {
        super(extractor, expected, input -> {
                    System.out.println("input is ::::" + input);
                    boolean result = false;
                    String expectedStr = expected.readFor((Request) null).toString();
                    String[] tempStringArray = expectedStr.split("#@#");

                    System.out.println("expectedStr is ::::" + expectedStr);

                    for (String tmpString : tempStringArray) {

                        result = result || (input.equals(tmpString));
                    }

                    return result;
                }


        );
    }

    @Override
    protected RequestMatcher newMatcher(final RequestExtractor<T> extractor, final Resource resource) {
        return new EqRequestMatcher<>(extractor, resource);
    }
}
