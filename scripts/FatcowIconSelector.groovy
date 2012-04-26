/*
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * @author Andres Almiray
 */

import javax.swing.JFrame
import groovy.swing.SwingBuilder
import org.springframework.core.io.support.PathMatchingResourcePatternResolver
import java.util.concurrent.CountDownLatch

target(fatcowIconSelector: "Displays all Fatcow icons") {
    def icons = []
    def pathResolver = new PathMatchingResourcePatternResolver(this.class.classLoader)
    pathResolver.getResources('classpath*:/fatcow/16x16/*.png').each { r ->
        def (m, icon) = (r.getURL().path =~ /.*\/([a-zA-Z_\d\-]+)\.png/)[0]
        icons << icon
    }
    
    // hack to avoid script from terminating before time
    CountDownLatch latch = new CountDownLatch(1i)
    def swing = new SwingBuilder()
    swing.edt {
        swing.frame(title: 'Fatcow Icons', pack: true, visible: true, resizable: true,
                    defaultCloseOperation: JFrame.DISPOSE_ON_CLOSE, preferredSize: [320, 420],
                    windowClosed: { latch.countDown() }) {
            scrollPane {
                panel {
                    gridLayout(cols: 6, rows: icons.size()/3)
                    icons.each { icon ->
                        label(icon: imageIcon("/fatcow/16x16/${icon}.png"), toolTipText: icon)
                        label(icon: imageIcon("/fatcow/32x32/${icon}.png"), toolTipText: icon)
                    } 
                }
            }
        }
    }

    latch.await()
}
setDefaultTarget(fatcowIconSelector)
